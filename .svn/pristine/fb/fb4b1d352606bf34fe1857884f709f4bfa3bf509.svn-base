package com.age123.outdoor.base.dao.complexQuery;

import java.io.Serializable;

public class Sort implements Serializable {

	private static final long serialVersionUID = 7026434198845897214L;
	private String property;
	private String tableAlias;
	private String column;
	private Direction direction;

	public Sort() {
		super();
		direction = Direction.ASC;
	}

	public Sort(String property) {
		this();
		this.property = property;
	}

	public Sort(String property, Direction direction) {
		this();
		this.property = property;
		this.direction = direction;
	}

	public static enum Direction {
		ASC, DESC;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getTableAlias() {
		return tableAlias;
	}

	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
