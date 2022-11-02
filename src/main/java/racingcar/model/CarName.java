package racingcar.model;

import racingcar.util.Message;

public class CarName {
    public static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validBlank(name);
        validLength(name);
        this.name = name;
    }

    private void validBlank(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_IS_BLANK.getMessage());
        }
    }

    private void validLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_VALID_CAR_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
