package com.test.core.exception;

public class DataProcessorException extends Exception {

	public DataProcessorException() {
	}

	public DataProcessorException(String message) {
		super(message);
	}

	public DataProcessorException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataProcessorException(Throwable cause) {
		super(cause);
	}

	public DataProcessorException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
