package com.slm.framework.factory;

import com.slm.framework.core.UnLabeledDataParser;
import com.slm.framework.model.RealVector;

public class UnLabeledDataFactory extends AbstractDataFactory<RealVector> {

	public UnLabeledDataFactory() {
		setDataParser(new UnLabeledDataParser());
	}

}
