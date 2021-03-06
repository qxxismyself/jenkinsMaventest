package com.age123.outdoor.base.dao.impl.mybatis.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.age123.outdoor.base.dao.dialect.Dialect;
import com.age123.outdoor.base.dao.impl.mybatis.DialectParser;
import com.age123.outdoor.base.dao.impl.mybatis.modelParser.Property;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	
	private static final Logger log = LoggerFactory.getLogger(PageInterceptor.class);
	
	
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory());
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
		if ((rowBounds != null) && (rowBounds != RowBounds.DEFAULT)) {
            Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
            Dialect dialect = DialectParser.parse(configuration);
            String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
            sql = dialect.addLimitString(sql, rowBounds.getOffset(), rowBounds.getLimit());

            metaStatementHandler.setValue("delegate.boundSql.sql", sql);
            metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
            metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		}

		log.debug("SQL : " + boundSql.getSql());
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {}

}