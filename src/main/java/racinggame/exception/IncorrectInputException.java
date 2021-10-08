/*
 * IncorrectInputException
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.exception;

public class IncorrectInputException extends RuntimeException {

    private final String prefix = "[ERROR]";

    public IncorrectInputException() {
        super();
    }

    public IncorrectInputException(String message) {
        super(message);
    }

    public IncorrectInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return String.format("%s %s", this.prefix, super.getMessage());
    }
}
