package com.honeywell.bms.exception;

public class BMSException extends RuntimeException {

	private static final long serialVersionUID = -8643063277644634114L;

	public BMSException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public BMSException() {
		super();
	}

	public BMSException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BMSException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BMSException(Throwable arg0) {
		super(arg0);
	}

}