package com.racingcar.common.exception;

public class RacingCarException extends RuntimeException {

	public RacingCarException(String message) {
		super(message);
	}

	public RacingCarException(String message, Throwable cause) {
		super(message, cause);
	}

	public RacingCarException(Throwable cause) {
		super(cause);
	}
}
