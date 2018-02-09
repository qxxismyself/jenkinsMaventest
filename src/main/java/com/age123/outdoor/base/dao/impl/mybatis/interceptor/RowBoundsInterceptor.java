package com.age123.outdoor.base.dao.impl.mybatis.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }) })
public class RowBoundsInterceptor implements Interceptor {
	

	private static ThreadLocal<RowBounds> rowBounds = new ThreadLocal<RowBounds>();

	public static RowBounds getRowBounds() {
		RowBounds rowBounds = RowBoundsInterceptor.rowBounds.get();
		RowBoundsInterceptor.rowBounds.remove();
		return rowBounds;
	}

	public static void setRowBounds(RowBounds rowBounds) {
		RowBoundsInterceptor.rowBounds.set(rowBounds);
	}

	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();

		RowBounds rowBounds = getRowBounds();
		if (rowBounds != null) {
			args[2] = rowBounds;
		}

		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}

}