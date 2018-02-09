package com.age123.outdoor.base.dao.complexQuery;

import java.util.ArrayList;
import java.util.List;

public class QueryParamBuilder {

    private List<CustomQueryParam> queryParams;

    public QueryParamBuilder() {
        queryParams = new ArrayList<CustomQueryParam>();
    }

    public static QueryParamBuilder newBuilder() {
        return new QueryParamBuilder();
    }

    public QueryParamBuilder addWithValueQueryParam(String property, String operator, Object value) {
        queryParams.add(new WithValueQueryParam(property, operator, value));
        return this;
    }

    public QueryParamBuilder addNoValueQueryParam(String property, String condition) {
        queryParams.add(new NoValueQueryParam(property, condition));
        return this;
    }

    public List<CustomQueryParam> build() {
        return queryParams;
    }

}
