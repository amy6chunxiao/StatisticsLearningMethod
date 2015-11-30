package com.slm.framework.factory;

import com.slm.framework.core.UnLabeledDataParser;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.interfaces.DataSet;

public class UnLabeledDataFactory extends AbstractDataFactory {

	public UnLabeledDataFactory() {
		setDataParser(new UnLabeledDataParser());
	}

	@Override
	public DataSet getTrainSet() {
		return null;
	}

	@Override
	public DataSet getValidSet() {
		return null;
	}

	@Override
	public DataSet getData() {
		return null;
	}

}
