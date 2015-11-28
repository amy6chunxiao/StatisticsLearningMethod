package com.business.model;

import com.slm.framework.model.LabeledDataSet;

public class KNNNode {
	private LabeledDataSet dataSet;
	private double distance;

	public KNNNode(LabeledDataSet dataSet) {
		this.dataSet = dataSet;
	}

	public LabeledDataSet getDataSet() {
		return dataSet;
	}

	public void setDataSet(LabeledDataSet dataSet) {
		this.dataSet = dataSet;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
