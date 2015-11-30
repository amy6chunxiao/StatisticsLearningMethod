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
public class KNNNode extends Example implements Comparable<KNNNode> {
	private double distance;

	public KNNNode(double[] data, String label) {
		super(data, label);
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(KNNNode o) {
		if (distance > o.distance)
			return 1;
		else if (distance == o.distance)
			return 0;
		else
			return -1;
	}

}
