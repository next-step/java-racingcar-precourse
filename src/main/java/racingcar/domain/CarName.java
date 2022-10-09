package racingcar.domain;

import racingcar.constant.Constant;
import racingcar.constant.Message;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() < Constant.CAR_NAME_MIN_LENGTH || carName.length() > Constant.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_LENGTH);
        }
    }


    public String getCarName() {
        return carName;
    }
}
