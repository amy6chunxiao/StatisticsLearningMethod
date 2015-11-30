package com.slm.framework.factory;

import com.slm.framework.core.LabeledDataParser;
import com.slm.framework.model.Example;

public class LabeledDataFactory extends AbstractDataFactory<Example> {

	public LabeledDataFactory() {
		setDataParser(new LabeledDataParser());
	}

}
