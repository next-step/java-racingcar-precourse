package util;

public interface InputValidator {
    void checkInputValue(Object input);
    default void raiseIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
}
