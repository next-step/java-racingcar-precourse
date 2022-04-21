package racingcar.domain;

import static racingcar.common.ValidationCheck.carNamelengthValidation;

import racingcar.common.SystemMessage;

public class RacingCar {

    private String name;

    public RacingCar(String name) {
        if (!carNamelengthValidation(name)) {
            throw new IllegalArgumentException(SystemMessage.CAR_NAME_LENGTH_EXCEPTION);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
