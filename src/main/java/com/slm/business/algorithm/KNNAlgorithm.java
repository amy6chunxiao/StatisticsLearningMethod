package com.slm.business.algorithm;

import com.slm.framework.core.AbstractAlgorithm;
import com.slm.framework.interfaces.DataSet;

public class KNNAlgorithm extends AbstractAlgorithm {
	public DataSet run(DataSet trainSet, DataSet validSet, double k) {
		return validSet;
		
	}
}
