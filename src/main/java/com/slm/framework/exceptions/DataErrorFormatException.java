package com.slm.framework.exceptions;

import org.apache.log4j.Logger;

public class DataErrorFormatException extends Exception {
	private final Logger log = Logger.getLogger(DataErrorFormatException.class);

	public DataErrorFormatException() {
	}

	public DataErrorFormatException(String string) {
		log.error(string);
	}
}
