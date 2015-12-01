package com.slm.framework.core;

import java.util.Random;

import org.apache.log4j.Logger;

import com.slm.framework.common.SplitMethods;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.interfaces.DataSpliter;
import com.slm.framework.model.DataSplitController;

public class DataSpliterImpl<T> implements DataSpliter<T> {

	private final Logger log = Logger.getLogger(DataSpliterImpl.class);
	private int dataSize;
	private int splitSize;
	private double ratio;
	private DataSet<T> dataSet;
	private SplitMethods splitMethod;

	// 切分得到的训练集和测试集
	private DataSet<T> trainSet;
	private DataSet<T> validSet;

	public DataSpliterImpl(DataSet<T> dataSet) {
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
		log.info("splitting..........split way is" + this);
		log.info("trainset is" + trainSet);
		log.info("validset is" + validSet);
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

	@Override
	public DataSet<T> getTrainSet() {
		return trainSet;
	}

	@Override
	public DataSet<T> getValidSet() {
		return validSet;
	}

}
