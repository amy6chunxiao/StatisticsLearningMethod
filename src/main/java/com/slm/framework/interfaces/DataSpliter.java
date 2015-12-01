package com.slm.framework.interfaces;

import com.slm.framework.model.DataSplitController;

/**
 * 
 * Title: DataSpliter.java
 * 
 * @description:切分数据集的工具，将数据集分成训练集和测试集
 * @author liucx
 * @created 2015年11月26日 下午3:00:52
 */
public interface DataSpliter<T> {
	public void split();

	public void split(DataSplitController dsc);

	public DataSet<T> getTrainSet();

	public DataSet<T> getValidSet();
}
