package racingcar.domain;

import racingcar.ui.ConsoleMessage;

public class CarName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        String trimmedName = name.trim();
        verifyName(trimmedName);
        this.name = trimmedName;
    }

    String getName() {
        return name;
    }

    private void verifyName(String name) {
        if (isValid(name)) {
            throw new IllegalArgumentException(ConsoleMessage.CAR_NAME_ERROR.getMessage());
        }
    }

    private boolean isValid(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }
}
