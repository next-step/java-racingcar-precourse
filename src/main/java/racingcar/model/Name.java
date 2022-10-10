package racingcar.model;


import racingcar.constant.ConstantNumber;
import racingcar.constant.InfoMessage;

public class Name {
    private final String value;

    public Name(String value) {
        if (value == null || value.trim().isEmpty() || value.length() > ConstantNumber.MAX_LENGTH_FOR_CAR_NAME) {
            throw new IllegalArgumentException(
                    String.format("%s: %s is not suitable for car name", InfoMessage.ERROR_MESSAGE_BEGIN, value));
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
