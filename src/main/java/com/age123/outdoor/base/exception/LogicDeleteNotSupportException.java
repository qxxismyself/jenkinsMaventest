package com.age123.outdoor.base.exception;

public class LogicDeleteNotSupportException extends RuntimeException {

    private static final long serialVersionUID = 8688673825230163019L;

    public LogicDeleteNotSupportException() {
        super("不支持逻辑删除！请实现ILogicDeletable接口！");
    }

}
