package racinggame.domain;

import racinggame.enums.ErrorMessageEnum;

public class Name {
    private String name;
    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 1;

    public Name(String carName) {
        validateNameLength(carName);
        this.name = carName;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String carName) {
        if(carName == null || carName.length() > MAX_NAME_LENGTH || carName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessageEnum.INPUT_CAR_NAME_SIZE_ERROR.getMessage());
        }
    }
}
