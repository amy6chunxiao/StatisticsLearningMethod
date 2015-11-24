package com.slm.framework.model;

import org.apache.log4j.Logger;

public abstract class DataSet {
	private int rowNum;
	private int colNum;

	public int getColNum() {
		return colNum;
	}

	public void setColNum(int colNum) {
		this.colNum = colNum;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
}