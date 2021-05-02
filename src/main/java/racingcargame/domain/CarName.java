package racingcargame.domain;

import racingcargame.exception.NameLengthExceededException;

public class CarName {
    public static final String MESSAGE_EXCEEDED_NAME_LENGTH = "이름이 다섯 글자를 초과할 수 없습니다";
    String carName;

    private CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public static CarName of(String carName) {
        return new CarName(carName);
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new NameLengthExceededException(MESSAGE_EXCEEDED_NAME_LENGTH);
        }
    }
}
