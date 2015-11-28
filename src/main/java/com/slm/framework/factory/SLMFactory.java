package com.slm.framework.factory;

import com.slm.framework.interfaces.DataFactory;

public class SLMFactory {
	private final static DataFactory labeledDataFactory = null;
	private final static DataFactory unLabeledDataFactory = null;

	public static DataFactory getLDataFactoryInstance() {
		if (labeledDataFactory == null)
			return new LabeledDataFactory();
		else
			return labeledDataFactory;
	}

	public static DataFactory getUnLabeledDataFactory() {
		if (unLabeledDataFactory == null)
			return new UnLabeledDataFactory();
		else
			return unLabeledDataFactory;
	}
}
