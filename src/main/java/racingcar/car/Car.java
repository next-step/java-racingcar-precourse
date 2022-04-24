package racingcar.car;

import static racingcar.util.MyUtils.lengthNotIn;

import java.util.Objects;

public class Car {

    public static final int CAR_NAME_MIN_LENGTH = 1;
    public static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

    public Car(String carName) {
        assertCarName(carName);
        this.name = carName;
    }

    public String getName() {
        return this.name;
    }

    private void assertCarName(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("자동차 이름은 null 일 수 없습니다");
        } else if (lengthNotIn(carName, CAR_NAME_MIN_LENGTH, CAR_NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException("자동차 이름은 1~5 글자만 허용됩니다");
        } else if (!carName.matches("[a-zA-Z가-힣]*")) {
            throw new IllegalArgumentException("자동차 이름은 한글/영문만 허용됩니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
