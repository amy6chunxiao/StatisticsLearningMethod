package com.slm.framework.factory;

import com.slm.framework.core.UnLabeledDataParser;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.DataSplitController;
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
	public UnLabeledDataSet[] getTrainSetAndValidSet(DataSplitController dsc) {
		return (UnLabeledDataSet[]) super.getTrainSetAndValidSet(dsc);
	}

	@Override
	public UnLabeledDataSet[] getTrainSetAndValidSet() {
		return (UnLabeledDataSet[]) super.getTrainSetAndValidSet();
	}

}
