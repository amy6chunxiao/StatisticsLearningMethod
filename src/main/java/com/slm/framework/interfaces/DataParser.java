package com.slm.framework.interfaces;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.RealVector;

public interface DataParser<T extends RealVector> {
	public DataSet<? extends RealVector> parse(String[] data)
			throws ParseErrorException;
}
