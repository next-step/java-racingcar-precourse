package racingcar.car;

import lombok.Getter;

@Getter
public class CarName {
    public static final int MAXIMUM_CAR_NAME_LENGTH = 6;
    public static final int ZERO_CAR_NAME_LENGTH = 0;
    private String carName;
    private static final String MORE_THAN_FIVE_LENGTH_ERRORMESSAGE = "[ERROR] 자동차 이름은 공백이 될 수 없고 5자 이하만 가능합니다.";

    public CarName(String carName) {
        if (carName.length() >= MAXIMUM_CAR_NAME_LENGTH || carName.length() == ZERO_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(MORE_THAN_FIVE_LENGTH_ERRORMESSAGE);
        }
        this.carName = carName;
    }
}
