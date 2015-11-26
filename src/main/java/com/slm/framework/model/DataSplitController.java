package com.slm.framework.model;

import com.slm.framework.common.SplitMethods;

/**
 * 
 * Title: DataSplitController.java
 * 
 * @description:数据切分控制类，决定训练集和测试集行数、切分方式（随机？顺序切分）等
 * @author liucx
 * @created 2015年11月26日 下午4:12:44
 */
public class DataSplitController {
	// 训练集测试集比例，默认比例0.7
	private double ratio = 0.7;
	// 切分方式,默认按顺序切分
	private Enum<SplitMethods> spliter = SplitMethods.inorder;

	public DataSplitController() {

	}

	public DataSplitController(double ratio) {
		this.ratio = ratio;
	}

	public DataSplitController(Enum<SplitMethods> spliter) {
		this.spliter = spliter;
	}

	public DataSplitController(Enum<SplitMethods> spliter, double ratio) {
		this.ratio = ratio;
		this.spliter = spliter;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public Enum<SplitMethods> getSpliter() {
		return spliter;
	}

	public void setSpliter(Enum<SplitMethods> spliter) {
		this.spliter = spliter;
	}

}
