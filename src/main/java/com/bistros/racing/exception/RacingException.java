package com.bistros.racing.exception;

public class RacingException extends RuntimeException {
    public RacingException() {
    }

    public RacingException(String message) {
        super(message);
    }

    public RacingException(String message, Throwable cause) {
        super(message, cause);
    }

    public RacingException(Throwable cause) {
        super(cause);
    }

    public RacingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
