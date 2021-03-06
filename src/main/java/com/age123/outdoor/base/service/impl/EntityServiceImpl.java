package com.age123.outdoor.base.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.age123.outdoor.base.dao.EntityDAO;
import com.age123.outdoor.base.dao.complexQuery.CustomQueryParam;
import com.age123.outdoor.base.dao.complexQuery.Sort;
import com.age123.outdoor.base.exception.DataCommitException;
import com.age123.outdoor.base.exception.LogicDeleteNotSupportException;
import com.age123.outdoor.base.model.Entity;
import com.age123.outdoor.base.model.ILogicDeletable;
import com.age123.outdoor.base.service.EntityService;

public abstract class EntityServiceImpl<T extends Entity> implements EntityService<T> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	//@Autowired
	private EntityDAO<T> entityDAO;

	public static Class<?> getEntityClass(EntityService entityService) {
		ParameterizedType genericSuperclass = (ParameterizedType) entityService.getClass().getGenericSuperclass();
		return (Class<?>) genericSuperclass.getActualTypeArguments()[0];
	}

	
	public List<T> getAll() {
		return entityDAO.getAll();
	}

	
	public T getById(Object id) {
		return entityDAO.getById(id);
	}

	
	public int countGet(T findParams) {
		return entityDAO.countGet(findParams);
	}

	
	public List<T> get(T findParams) {
		return entityDAO.get(findParams);
	}

	
	public List<T> get(T findParams, List<Sort> sortList, Integer start, Integer limit) {
		return entityDAO.get(findParams, sortList, start, limit);
	}

	
	public int countFind(T findParams) {
		return entityDAO.countFind(findParams);
	}

	
	public List<T> find(T findParams) {
		return entityDAO.find(findParams);
	}

	
	public List<T> find(T findParams, List<Sort> sortList, Integer start, Integer limit) {
		return entityDAO.find(findParams, sortList, start, limit);
	}

	
	public int countQuery(List<CustomQueryParam> customQueryParams) {
		return entityDAO.countQuery(customQueryParams);
	}

	
	public List<T> query(List<CustomQueryParam> customQueryParams, List<Sort> sortList) {
		return entityDAO.query(customQueryParams, sortList);
	}

	
	public List<T> query(List<CustomQueryParam> customQueryParams, List<Sort> sortList, Integer start, Integer limit) {
		return entityDAO.query(customQueryParams, sortList, start, limit);
	}

	
	public void insert(T t) {
		if (t == null) {
			return;
		}
		if (validate(t)) {
			if (entityDAO.insert(t) != 1) {
				throw new DataCommitException();
			}
		}
	}

	
	public void deleteById(Object id) {
		if (id == null) {
			return;
		}
		if (entityDAO.delete(id) != 1) {
			throw new DataCommitException();
		}
	}

	
	public void logicDelete(T t) {
		if (!(t instanceof ILogicDeletable)) {
			throw new LogicDeleteNotSupportException();
		}
		((ILogicDeletable) t).setDelete();
		update(t);
	}

	
	public void update(T t) {
		if (t == null) {
			return;
		}
		Assert.notNull(t.getId());
		if (validate(t)) {
			if (entityDAO.update(t) != 1) {
				throw new DataCommitException();
			}
		}
	}

	
	public int updateIgnoreDataCommitException(T t) {
		if (t == null) {
			return 0;
		}
		Assert.notNull(t.getId());
		if (validate(t)) {
			return entityDAO.update(t);
		}
		return 0;
	}

	/**
	 * 模板方法
	 * 
	 * @param t
	 */
	protected boolean validate(T t) {
		return true;
	}

}
