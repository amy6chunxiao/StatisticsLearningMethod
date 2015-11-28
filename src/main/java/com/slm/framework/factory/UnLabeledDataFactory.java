package com.slm.framework.factory;

import com.slm.framework.core.UnLabeledDataParser;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.UnLabeledDataSet;

public class UnLabeledDataFactory extends AbstractDataFactory {

	public UnLabeledDataFactory() {
		setDataParser(new UnLabeledDataParser());
	}

	@Override
	public UnLabeledDataSet getData(String src) throws ParseErrorException {
		return (UnLabeledDataSet) super.getData(src);
	}

	@Override
	public UnLabeledDataSet getTrainSet() {
		return (UnLabeledDataSet) trainSet;
	}

	@Override
	public UnLabeledDataSet getValidSet() {
		return (UnLabeledDataSet) trainSet;
	}

	@Override
	public UnLabeledDataSet getData() {
		return (UnLabeledDataSet) data;
	}

}
