package com.age123.outdoor.base.dao.dialect;

import java.util.List;

import com.age123.outdoor.base.dao.complexQuery.Sort;

public class H2Dialect extends Dialect {

	@Override
	public String addLimitString(String sql, int offset, int limit) {
		return MySql5PageHepler.addLimitString(sql, offset, limit);
	}

    @Override
    public String addSortString(String sql, List<Sort> sortList) {
        return SortHelper.addSortString(sql, sortList);
    }

}