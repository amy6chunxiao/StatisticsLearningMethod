package com.slm.framework.factory;

import com.slm.framework.core.LabeledDataParser;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.RealDataSet;

public class LabeledDataFactory extends AbstractDataFactory {

	public LabeledDataFactory() {
		setDataParser(new LabeledDataParser());
	}

	@Override
	public RealDataSet getData(String src) throws ParseErrorException {
		return (RealDataSet) super.getData(src);
	}

	@Override
	public RealDataSet getTrainSet() {
		return (RealDataSet) trainSet;
	}

	@Override
	public RealDataSet getValidSet() {
		return (RealDataSet) validSet;
	}

	@Override
	public RealDataSet getData() {
		return (RealDataSet) data;
	}


}
