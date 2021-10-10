package racinggame.domain;

import racinggame.enums.ErrorMessageEnum;

public class CarName {
    private String carName;
    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 1;

    public CarName(final String carName) {
        validateNameLength(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateNameLength(String carName) {
        if(carName.length() > MAX_NAME_LENGTH || carName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessageEnum.INPUT_CAR_NAME_SIZE_ERROR.getMessage());
        }
    }
}
