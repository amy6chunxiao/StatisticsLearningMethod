package com.slm.framework.factory;

import com.slm.framework.core.LabeledDataParser;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.DataSplitController;
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
	public LabeledDataSet[] getTrainSetAndValidSet(DataSplitController dsc) {
		return (LabeledDataSet[]) super.getTrainSetAndValidSet(dsc);
	}

	@Override
	public LabeledDataSet[] getTrainSetAndValidSet() {
		return (LabeledDataSet[]) super.getTrainSetAndValidSet();
	}

}
