package com.slm.framework.interfaces;

import java.util.Iterator;
import java.util.List;

import com.slm.framework.model.RealVector;

public interface DataSet<T extends RealVector> {
	public DataSet<T> subDataSet(int fromIndex, int toIndex);

	public List<T> getData();

	public Iterator<T> iterator();

	public int getRowNum();

	public void setRowNum(int rowNum);

	public int getColNum();

	public void setColNum(int colNum);
}
