package com.slm.business.service;

import java.util.Comparator;

import com.slm.framework.model.RealVector;

/**
 * 
 * Title: KDTreeComparator.java
 * 
 * @description:kd树比较器，用于比较数据集中每行数据第k维大小
 * @author liucx
 * @created 2015年12月2日 上午11:20:05
 */
public class KDTreeComparator implements Comparator<RealVector> {

	private int dimension;

	public KDTreeComparator(int dimension) {
		this.dimension = dimension;
	}

	@Override
	public int compare(RealVector o1, RealVector o2) {
		if (o1.get(dimension) > o2.get(dimension))
			return 1;
		else if (o1.get(dimension) == o2.get(dimension))
			return 0;
		else
			return -1;
	}

}
