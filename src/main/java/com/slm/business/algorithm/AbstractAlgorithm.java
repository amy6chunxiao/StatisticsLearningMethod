package com.slm.business.algorithm;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.factory.SLMFactory;
import com.slm.framework.interfaces.Algorithm;
import com.slm.framework.interfaces.DataFactory;
import com.slm.framework.model.DataSet;
import com.slm.framework.model.DataSplitController;

public class AbstractAlgorithm implements Algorithm {
	private DataFactory factory = SLMFactory.getLDataFactoryInstance();

	@Override
	public DataSet getData(String sc) throws ParseErrorException {
		return factory.getData(sc);
	}

	@Override
	public DataSet getTrainSet() {
		return factory.getTrainSet();
	}

	@Override
	public DataSet getValidSet() {
		return factory.getValidSet();
	}

	@Override
	public void splitDataSet() {
		factory.splitDataSet();
	}

	@Override
	public void splitDataSet(DataSplitController dsc) {
		factory.splitDataSet(dsc);
	}
}
