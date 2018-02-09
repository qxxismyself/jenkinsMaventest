package com.age123.outdoor.base.dao.impl.mybatis.typeHandler;

import com.alibaba.fastjson.JSONArray;

public class JSONArrayTypeHandler extends JSONTypeHandler<JSONArray> {

    public JSONArrayTypeHandler(Class<JSONArray> type) {
        super(type);
    }

    @Override
    protected JSONArray parseJSONString(String jsonString) {
        return JSONArray.parseArray(jsonString);
    }

}
