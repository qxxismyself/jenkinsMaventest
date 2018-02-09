package com.age123.outdoor.base.dao.dialect;

public enum DBDialectType {

    MYSQL("mysql"), ORACLE("oracle"), H2("h2");

    private String type;

    private DBDialectType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
