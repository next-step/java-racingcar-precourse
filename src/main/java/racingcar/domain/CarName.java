package racingcar.domain;

import static racingcar.Constants.ErrorMessage.CAR_NAME_NOT_VALID_ERR_MSG;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String carName;

    public CarName(String carName){
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName){
        validateNull(carName);
        validateLength(carName);
    }

    public static void validateNull(String carName){
        if(carName == null){
            throw new IllegalArgumentException(CAR_NAME_NOT_VALID_ERR_MSG);
        }
    }

    public static void validateLength(String carName) {
        if(carName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(CAR_NAME_NOT_VALID_ERR_MSG);
        }
    }

    @Override
    public String toString() {
        return carName;
    }
}
