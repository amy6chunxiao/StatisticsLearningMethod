package com.slm.framework.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class LabeledDataSet extends DataSet {
	private final Logger log = Logger.getLogger(LabeledDataSet.class);
	private List<Example> data;

	public LabeledDataSet(List<Example> data) {
		this.data = data;
		setRowNum(data.size());
		setColNum(data.isEmpty() ? 0 : data.get(0).size());
		log.info("init dataset:" + data);
	}

	public LabeledDataSet(Example[] data) {

		this.data = new ArrayList<>();
		for (Example example : data) {
			this.data.add(example);
		}
		setRowNum(data.length);
		setColNum(data[0] == null ? 0 : data[0].size());
		log.info("init dataset"+data);
	}
	
}
