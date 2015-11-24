package com.slm.framework.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * Title: DataErrorFormatException.java
 * 
 * @description:数据格式错误时抛出该异常
 * @author liucx
 * @created 2015年11月24日 上午11:18:14
 */
public class DataErrorFormatException extends Exception {
	private final Logger log = Logger.getLogger(DataErrorFormatException.class);

	public DataErrorFormatException() {
	}

	public DataErrorFormatException(String string) {
		log.error(string);
	}
}
