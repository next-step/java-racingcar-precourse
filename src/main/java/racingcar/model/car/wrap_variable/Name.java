package racingcar.model.car.wrap_variable;

import racingcar.constant.Message;

public class Name {
    private static final int CAR_NAME_LIMIT_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name.length() < 1 || name.length() > CAR_NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE + Message.ERROR_CAR_NAME_LENGTH);
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
