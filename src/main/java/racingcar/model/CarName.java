package racingcar.model;

import racingcar.constant.Length;
import racingcar.message.ErrorMessage;

public class CarName {
    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    public static void validate(String name) {
        if(name.length() > Length.MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_NAME_LENGTH_ERROR.getMessage());
        }

        if(name.length() < Length.MIN_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }

}
