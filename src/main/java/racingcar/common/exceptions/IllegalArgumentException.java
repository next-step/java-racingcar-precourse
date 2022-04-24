package racingcar.common.exceptions;

public class IllegalArgumentException extends java.lang.IllegalArgumentException {

    public IllegalArgumentException(String message) {
        super("[ERROR] " + message);
    }

}
