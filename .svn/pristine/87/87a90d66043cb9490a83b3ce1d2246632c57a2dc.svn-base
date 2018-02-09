package com.age123.outdoor.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.age123.outdoor.base.dao.complexQuery.CustomQueryParam;
import com.age123.outdoor.base.dao.complexQuery.Sort;
import com.age123.outdoor.base.dao.impl.mybatis.BaseSQLProvider;
import com.age123.outdoor.base.model.Entity;

public interface EntityDAO<T extends Entity> {

	/**
	 * 默认获取单表所有数据。可通过mapper.xml覆盖默认sql。
	 * 
	 * @return
	 */
	@SelectProvider(type = BaseSQLProvider.class, method = "getAll")
	@ResultMap("getMap")
	public List<T> getAll();

	@SelectProvider(type = BaseSQLProvider.class, method = "getById")
	@ResultMap("getMap")
	public T getById(Object id);

	@SelectProvider(type = BaseSQLProvider.class, method = "get")
	@ResultMap("getMap")
	public T getOne(@Param("findParams") T findParams);

	/**
	 * 见{@link com.age123.outdoor.base.dao.EntityDAO#get}
	 * 
	 * @return
	 */
	@SelectProvider(type = BaseSQLProvider.class, method = "countGet")
	public int countGet(@Param("findParams") T findParams);

	/**
	 * 根据当前表中的属性精确查询。模糊查询可用{@link com.age123.outdoor.base.dao.EntityDAO#find}，复杂查询可用
	 * {@link com.age123.outdoor.base.dao.EntityDAO#query}
	 * 
	 * @return
	 */
	@SelectProvider(type = BaseSQLProvider.class, method = "get")
	@ResultMap("getMap")
	public List<T> get(@Param("findParams") T findParams);

	@SelectProvider(type = BaseSQLProvider.class, method = "get")
	@ResultMap("getMap")
	public List<T> get(@Param("findParams") T findParams, @Param("sortList") List<Sort> sortList,
			@Param("start") Integer start, @Param("limit") Integer limit);

	/**
	 * 见{@link com.age123.outdoor.base.dao.EntityDAO#find}
	 * 
	 * @return
	 */
	@SelectProvider(type = BaseSQLProvider.class, method = "countFind")
	public int countFind(@Param("findParams") T findParams);

	/**
	 * 根据当前表中的属性模糊查询。精确查询可用{@link com.age123.outdoor.base.dao.EntityDAO#get}，复杂查询可用
	 * {@link com.age123.outdoor.base.dao.EntityDAO#query}
	 * 
	 * @return
	 */
	@SelectProvider(type = BaseSQLProvider.class, method = "find")
	@ResultMap("getMap")
	public List<T> find(@Param("findParams") T findParams);

	@SelectProvider(type = BaseSQLProvider.class, method = "find")
	@ResultMap("getMap")
	public List<T> find(@Param("findParams") T findParams, @Param("sortList") List<Sort> sortList,
			@Param("start") Integer start, @Param("limit") Integer limit);

	/**
	 * 见{@link com.age123.outdoor.base.dao.EntityDAO#query}
	 * 
	 * @return
	 */
	@SelectProvider(type = BaseSQLProvider.class, method = "countQuery")
	public int countQuery(@Param("queryParams") List<CustomQueryParam> customQueryParams);

	/**
	 * 复杂查询。另见{@link com.age123.outdoor.base.dao.EntityDAO#get}、
	 * {@link com.age123.outdoor.base.dao.EntityDAO#find}。例：
	 * 
	 * <pre>
	 * <code>
	 * QueryParamBuilder queryParamBuilder = QueryParamBuilder.newBuilder();
	 * queryParamBuilder.addWithValueQueryParam("city", "=", city);
	 * queryParamBuilder.addWithValueQueryParam("name", "LIKE", "%" + name + "%");
	 * queryParamBuilder.addWithValueQueryParam("date", ">", time1);
	 * queryParamBuilder.addWithValueQueryParam("date", "<=", time2);
	 * List<CustomQueryParam> queryParams = queryParamBuilder.build();
	 * </code>
	 * </pre>
	 *
	 * @return
	 */
	@SelectProvider(type = BaseSQLProvider.class, method = "query")
	@ResultMap("getMap")
	public List<T> query(@Param("queryParams") List<CustomQueryParam> customQueryParams,
			@Param("sortList") List<Sort> sortList);

	@SelectProvider(type = BaseSQLProvider.class, method = "query")
	@ResultMap("getMap")
	public List<T> query(@Param("queryParams") List<CustomQueryParam> customQueryParams,
			@Param("sortList") List<Sort> sortList, @Param("start") Integer start, @Param("limit") Integer limit);

	@InsertProvider(type = BaseSQLProvider.class, method = "insert")
	public int insert(T t);

	@DeleteProvider(type = BaseSQLProvider.class, method = "delete")
	public int delete(Object id);

	@UpdateProvider(type = BaseSQLProvider.class, method = "update")
	public int update(T t);

}
