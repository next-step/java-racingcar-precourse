package racingcar.domain;

import racingcar.common.ErrorMessage;

/**
 * 자동차 이름
 *
 * @author suji
 * @date 2022-04-23
 **/
public class CarName {

    private static final int MAX_SIZE = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_EMPTY);
        }
        if (greaterThenMaxSize(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_SIZE);
        }
    }

    private boolean greaterThenMaxSize(String name) {
        return name.length() > MAX_SIZE;
    }

    private boolean isEmpty(String name) {
        return name == null || name.trim().length() == 0;
    }

    public String getName() {
        return name;
    }
}
