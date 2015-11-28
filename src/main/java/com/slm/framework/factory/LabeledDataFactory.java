package com.slm.framework.factory;

import com.slm.framework.core.LabeledDataParser;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.LabeledDataSet;

public class LabeledDataFactory extends AbstractDataFactory {

	public LabeledDataFactory() {
		setDataParser(new LabeledDataParser());
	}

	@Override
	public LabeledDataSet getData(String src) throws ParseErrorException {
		return (LabeledDataSet) super.getData(src);
	}

	@Override
	public LabeledDataSet getTrainSet() {
		return (LabeledDataSet) trainSet;
	}

	@Override
	public LabeledDataSet getValidSet() {
		return (LabeledDataSet) validSet;
	}

	@Override
	public LabeledDataSet getData() {
		return (LabeledDataSet) data;
	}


}
