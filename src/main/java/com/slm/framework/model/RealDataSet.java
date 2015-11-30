package com.slm.framework.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class RealDataSet<T extends RealVector> extends AbstractDataSet<T> {
	private final Logger log = Logger.getLogger(RealDataSet.class);
	private List<T> data;

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
		setRowNum(data.size());
		setColNum(data.isEmpty() ? 0 : data.get(0).size());
		log.info("init dataset" + data);
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

}
