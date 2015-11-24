package com.slm.framework.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class UnLabeledDataSet extends DataSet{
	private final Logger log = Logger.getLogger(UnLabeledDataSet.class);
	private List<RealVector> data;

	public UnLabeledDataSet(List<RealVector> data) {
		this.data = data;
		setRowNum(data.size());
		setColNum(data.isEmpty() ? 0 : data.get(0).size());
		log.info("init dataset:" + data);
	}

	public UnLabeledDataSet(RealVector[] data) {

		this.data = new ArrayList<>();
		for (RealVector example : data) {
			this.data.add(example);
		}
		setRowNum(data.length);
		setColNum(data[0] == null ? 0 : data[0].size());
		log.info("init dataset"+data);
	}
}
