package com.slm.framework.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class LabeledDataSet extends DataSet {
	private final Logger log = Logger.getLogger(LabeledDataSet.class);
	private List<Example> data;

	public LabeledDataSet(List<Example> data) {
		this.data = data;
		setRowColNum();
	}

	public LabeledDataSet(Example[] data) {

		this.data = new ArrayList<>();
		for (Example example : data) {
			this.data.add(example);
		}
		setRowColNum();
	}

	private void setRowColNum() {
		setRowNum(data.size());
		setColNum(data.isEmpty() ? 0 : data.get(0).size());
		log.info("init dataset" + data);
	}

	public LabeledDataSet subDataSet(int fromIndex, int toIndex) {
		List<Example> subData = data.subList(fromIndex, toIndex);
		return new LabeledDataSet(subData);
	}

	@Override
	public List<Example> getData() {
		return data;
	}

}
