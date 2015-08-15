package com.kms.training.codequaility.cleancode.builders;

public class ChartException extends Exception {

	private static final long serialVersionUID = 2458636902894949407L;

	private ChartErrorCode code;

	public ChartException(ChartErrorCode code) {

	}

	public ChartErrorCode getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		String message = "Chưa modify";

		return message;
	}

}
