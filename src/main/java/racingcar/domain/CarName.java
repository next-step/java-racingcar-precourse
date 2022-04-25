package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ERROR_CAR_NAME_NEED = "자동차의 이름이 존재 해야 합니다.";
    private static final String ERROR_CAR_NAME_LENGTH = "자동차 이름은 5 글자를 넘어갈 수 없습니다.";

    private final String carName;

    public CarName(String carName) {
        validateName(carName.trim());
        this.carName = carName;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_NEED);
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
