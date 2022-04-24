package racingcar.model.car;

import racingcar.global.errorcode.ErrorCode;

public class CarName {

    private String carName;

    public CarName(String inputCarName) {
        lengthValidation(inputCarName);
        this.carName = inputCarName;
    }

    public String getCarName() {
        return carName;
    }

    private void lengthValidation(String inputCarName) {
        if (inputCarName.length() > 5) {
            throw new IllegalArgumentException(ErrorCode.ILLEGAL_CAR_NAME_LENGTH.getMessage());
        }
    }
}
