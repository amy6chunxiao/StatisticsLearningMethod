package com.slm.framework.interfaces;

import java.util.Iterator;
import java.util.List;

public interface DataSet<T> {
	public DataSet<T> subDataSet(int fromIndex, int toIndex);

	public List<T> getData();

	public Iterator<T> iterator();

	public T get(int index);

	public int getRowNum();

	public void setRowNum(int rowNum);

	public int getColNum();

	public void setColNum(int colNum);

	public boolean isEmpty();
}
