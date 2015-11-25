package com.slm.framework.interfaces;

import com.slm.framework.exceptions.DataErrorFormatException;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.DataSet;

public interface DataFactory {
	public DataSet getData(String src) throws ParseErrorException,
			DataErrorFormatException;
}
