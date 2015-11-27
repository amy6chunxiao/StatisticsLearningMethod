package com.slm.framework.core;

import java.util.Random;

import com.slm.framework.common.SplitMethods;
import com.slm.framework.interfaces.DataSpliter;
import com.slm.framework.model.DataSet;
import com.slm.framework.model.DataSplitController;

public class DataSpliterImpl implements DataSpliter {

	private int dataSize;
	private int splitSize;
	private double ratio;
	private DataSet dataSet;
	private SplitMethods splitMethod;

	// 切分得到的训练集和测试集
	private DataSet trainSet;
	private DataSet validSet;

	public DataSpliterImpl(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	@Override
	public void split() {
		DataSplitController dsc = new DataSplitController();
		split(dsc);
	}

	@Override
	public void split(DataSplitController dsc) {
		this.ratio = dsc.getRatio();
		this.splitMethod = dsc.getSpliter();
		this.dataSize = dataSet.getRowNum();
		this.splitSize = (int) (ratio * dataSize);

		if (SplitMethods.random.equals(splitMethod))
			randomSplit();
		else if (SplitMethods.inorder.equals(splitMethod))
			inorderSplit();
		else
			randomThenInorderSplit();
	}

	private void randomSplit() {
		Random random = new Random();
		int index = random.nextInt(dataSize);

	}

	private void inorderSplit() {
		trainSet = dataSet.subDataSet(0, splitSize);
		validSet = dataSet.subDataSet(splitSize, dataSize);
	}

	private void randomThenInorderSplit() {
		Random random = new Random();
		int index = random.nextInt(dataSize);

	}

	public DataSet getTrainSet() {
		return trainSet;
	}

	public void setTrainSet(DataSet trainSet) {
		this.trainSet = trainSet;
	}

	public DataSet getValidSet() {
		return validSet;
	}

	public void setValidSet(DataSet validSet) {
		this.validSet = validSet;
	}

}
