package com.age123.outdoor.base.dao.complexQuery;

public class WithValueQueryParam extends CustomQueryParam {

	private static final long serialVersionUID = 551700614254917419L;
	private Object value;
	private String operator;

	public WithValueQueryParam(String property, String operator, Object value) {
		super.property = property;
		this.operator = operator;
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public String getOperator() {
		return operator;
	}

}
