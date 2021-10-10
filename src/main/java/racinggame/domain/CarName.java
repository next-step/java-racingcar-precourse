package racinggame.domain;

import racinggame.message.ErrorCode;

import java.util.NoSuchElementException;

public class CarName {

    private final String name;

    public CarName(String inputCarName) {
        validateName(inputCarName);
        this.name = inputCarName;
    }

    public String getName() {
        return name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public static void validateName(String name) {
        validateNullOrEmptyName(name);
        validateExceededName(name);
    }

    public static void validateNullOrEmptyName(String name) {
        if ("".equals(name) || name == null) {
            throw new NoSuchElementException(ErrorCode.NAME_NOT_BLANK.getMessage());
        }
    }

    public static void validateExceededName(String name) {
        if (name.length() > 5) {
            throw new NoSuchElementException(ErrorCode.NAME_EXCEEDED.getMessage());
        }
    }
}
