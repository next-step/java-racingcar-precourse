package racingcar.domain.car;

import racingcar.constant.ErrorConstant;

public class CarName {
    private String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public static CarName from(String name) {
        validateName(name);
        return new CarName(name);
    }

    public String getName() {
        return name;
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_NAME_IS_NOT_EMPTY);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_NAME_IS_TOO_LONG);
        }
    }
}
