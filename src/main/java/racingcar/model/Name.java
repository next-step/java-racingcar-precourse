package racingcar.model;

import racingcar.constants.NameMessage;

public class Name {
    private final String value;

    private Name(String name) {
        this.value = name;
    }

    public static Name valueOf(String name) {
        validNameLength(name);
        return new Name(name);
    }

    public static void validNameLength(String name) {
        if (isBlankEmpty(name) || isMoreThan5Length(name)) {
            throw new IllegalArgumentException(NameMessage.INVALID_NAME_LENGTH);
        }
    }

    private static boolean isMoreThan5Length(String name) {
        return name.trim().length() > 5;
    }

    private static boolean isBlankEmpty(String name) {
        return name.trim().isEmpty();
    }

    public String getName() {
        return value;
    }
}
