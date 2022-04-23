package racingcar.model;

import racingcar.model.error.ErrorMessage;

import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    protected Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE);
        }
        if (isOverNameLength(name)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_OVER_LENGTH);
        }

        return new Name(name);
    }

    private static boolean isBlank(String testName) {
        return Objects.isNull(testName) || testName.trim().isEmpty();
    }

    private static boolean isOverNameLength(String testName) {
        return testName.length() > NAME_MAX_LENGTH;
    }

    public String getName() {
        return this.name;
    }
}
