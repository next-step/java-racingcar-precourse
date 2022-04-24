package racingcar.domain;

import racingcar.common.GameConfig;
import racingcar.common.Message;

public class Name {
    private String name;

    public Name(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateEmpty(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_EMPTY);
        }
    }

    private void validateLength(String name) {
        if (name.length() > GameConfig.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_LENGTH);
        }
    }
}
