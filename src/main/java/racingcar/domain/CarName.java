package racingcar.domain;

import org.assertj.core.util.Strings;

public class CarName {
    public static final String ERROR_MESSAGE_CAR_NAME_IS_EMPTY = "자동차 이름은 비어있을 수 없습니다.";
    public static final int MAX_LENGTH_CAR_NAME = 5;
    public static final String ERROR_MESSAGE_OUT_OF_RANGE_CAR_NAME_LENGTH = "자동차 이름은 " + MAX_LENGTH_CAR_NAME + "자 이하만 가능합니다.";

    private String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
        validate(name);
        return new CarName(name);
    }

    private static void validate(String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME_IS_EMPTY);
        }

        if (name.length() > MAX_LENGTH_CAR_NAME) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE_CAR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
