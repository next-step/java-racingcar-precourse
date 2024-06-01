package util;

public interface InputValidator {
    void checkInputValue(String input);
    default void raiseIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
}
