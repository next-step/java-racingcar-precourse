package racingcar.domain;

import static racingcar.common.ValidationCheck.carNamelengthValidation;

import racingcar.common.SystemMessage;

public class RacingCar {

    private String name;
    private int goCount;

    public RacingCar(String name) {
        if (!carNamelengthValidation(name)) {
            throw new IllegalArgumentException(SystemMessage.CAR_NAME_LENGTH_EXCEPTION);
        }
        this.name = name;
        this.goCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getGoCount() {
        return this.goCount;
    }

    public void goRacingCar() {
    this.goCount++;
  }
}
