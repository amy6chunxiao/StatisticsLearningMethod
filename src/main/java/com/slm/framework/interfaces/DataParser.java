package com.slm.framework.interfaces;

import com.slm.framework.exceptions.ParseErrorException;

public interface DataParser<T> {
	public DataSet<T> parse(String[] data) throws ParseErrorException;
}
