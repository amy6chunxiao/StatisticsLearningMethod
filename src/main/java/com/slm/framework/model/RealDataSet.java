package com.slm.framework.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.slm.framework.interfaces.DataSet;
import com.slm.framework.interfaces.Vector;

/**
 * 
 * Title: RealDataSet.java
 * 
 * @description:数据集 包含{@link Vector}类型的一组数据
 * @author liucx
 * @created 2015年12月1日 下午3:28:39
 */
public class RealDataSet<T extends Vector<?>> implements DataSet<T> {
	private final Logger log = Logger.getLogger(RealDataSet.class);
	private List<T> data;
	private int rowNum;
	private int colNum;

	public RealDataSet(List<T> data) {
		this.data = data;
		setRowColNum();
	}

	public RealDataSet(T[] data) {

		this.data = new ArrayList<>();
		for (T tmp : data) {
			this.data.add(tmp);
		}
		setRowColNum();
	}

	private void setRowColNum() {
		setRowNum(data == null ? 0 : data.size());
		setColNum(data.isEmpty() ? 0 : (data.get(0) == null ? 0 : data.get(0)
				.size()));
	}

	public RealDataSet<T> subDataSet(int fromIndex, int toIndex) {
		List<T> subData = data.subList(fromIndex, toIndex);
		return new RealDataSet<T>(subData);
	}

	@Override
	public List<T> getData() {
		return data;
	}

	@Override
	public Iterator<T> iterator() {
		return data.iterator();
	}

	@Override
	public String toString() {
		return "RealDataSet [data=" + data + "]";
	}

	@Override
	public int getRowNum() {
		return 0;
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
