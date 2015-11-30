package com.slm.framework.model;

import com.slm.framework.interfaces.DataSet;

public abstract class AbstractDataSet<T extends RealVector> implements
		DataSet<T> {

	private int colNum;
	private int rowNum;

	@Override
	public int getRowNum() {
		return rowNum;
	}

	@Override
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	@Override
	public int getColNum() {
		return colNum;
	}

	@Override
	public void setColNum(int colNum) {
		this.colNum = colNum;
	}

}
