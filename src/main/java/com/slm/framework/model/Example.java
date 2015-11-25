package com.slm.framework.model;

import java.util.List;

/**
 * 
 * Title: Example.java
 * 
 * @description:带标记的一行数据，包括实向量数据和标签
 * @author liucx
 * @created 2015年11月24日 上午10:44:08
 */
public class Example extends RealVector {

	private String label;

	public Example(double[] data, String label) {
		super(data);
		this.label = label;
	}

	public Example(List<Double> data, String label) {
		super(data);
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Example [label=" + label + ", toString()=" + super.toString()
				+ "]";
	}
}
