package com.slm.framework.model;

import java.util.List;

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

	public abstract DataSet subDataSet(int fromIndex, int toIndex);

	public abstract List<? extends RealVector> getData();
}
