package com.business.model;

import com.slm.framework.model.Example;

/**
 * 
 * Title: KNNNode.java
 * 
 * @description:k近邻算法自定义model
 * @author liucx
 * @created 2015年11月28日 下午4:11:25
 */
public class KNNNode extends Example {
	private double distance;

	public KNNNode(double[] data, String label) {
		super(data, label);
	}

}
