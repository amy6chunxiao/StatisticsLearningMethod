package com.slm.framework.interfaces;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.DataSet;

public interface DataParser {
	public DataSet parse(String[] data) throws ParseErrorException;
}
