package racingcar.model.car;

import racingcar.constant.ErrorMessage;

public class CarName {
    private final String name;

    public CarName(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.trim().length() < CarConfig.MIN_CAR_NAME_LENGTH || name.trim().length() > CarConfig.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_CAR_NAMES_LENGTH, CarConfig.MIN_CAR_NAME_LENGTH,
                                  CarConfig.MAX_CAR_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
