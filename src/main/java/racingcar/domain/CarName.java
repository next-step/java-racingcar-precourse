package racingcar.domain;

import static racingcar.common.ErrorMessage.CAR_NAME_FORMAT;
import static racingcar.common.ErrorMessage.CAR_NAME_LENGTH;

public class CarName {

    private final String carName;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String CAR_FORMAT_REGEX = "^[0-9a-zA-Zㄱ-ㅎ가-힣]*$"; // 한글,영어,숫자만 허용

    public CarName(String carName) {
        validLength(carName);
        validFormat(carName);
        this.carName = carName;
    }

    private void validLength(String carName) {
        if (MIN_LENGTH <= carName.length() && carName.length() <= MAX_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(CAR_NAME_LENGTH);
    }

    private void validFormat(String carName) {
        if (carName.matches(CAR_FORMAT_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(CAR_NAME_FORMAT);
    }

    public String getCarName() {
        return carName;
    }
}
