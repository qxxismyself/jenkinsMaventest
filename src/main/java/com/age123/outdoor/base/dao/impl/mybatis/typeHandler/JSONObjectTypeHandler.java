package com.age123.outdoor.base.dao.impl.mybatis.typeHandler;

import com.alibaba.fastjson.JSONObject;

public class JSONObjectTypeHandler extends JSONTypeHandler<JSONObject> {

    public JSONObjectTypeHandler(Class<JSONObject> type) {
        super(type);
    }

    @Override
    protected JSONObject parseJSONString(String jsonString) {
        return JSONObject.parseObject(jsonString);
    }

}
