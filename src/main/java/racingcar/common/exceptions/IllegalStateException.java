package racingcar.common.exceptions;

public class IllegalStateException extends java.lang.IllegalStateException {

    public IllegalStateException(String message) {
        super("[ERROR] " + message);
    }

}
