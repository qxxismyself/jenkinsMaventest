package com.age123.outdoor.base.dao.dialect;

import java.util.List;

import com.age123.outdoor.base.dao.complexQuery.Sort;

public class MySql5Dialect extends Dialect {

	public String getLimitString(String sql, boolean hasOffset) {
		return MySql5PageHepler.addLimitString(sql, -1, -1);
	}

	@Override
	public String addLimitString(String sql, int offset, int limit) {
		return MySql5PageHepler.addLimitString(sql, offset, limit);
	}

    @Override
    public String addSortString(String sql, List<Sort> sortList) {
        return SortHelper.addSortString(sql, sortList);
    }

    public boolean supportsLimit() {
		return true;
	}

}