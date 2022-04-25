package racingcar.domain.car;

public class CarName {

    private final int CAR_NAME_MAX_SIZE = 5;
    private final String value;

    private CarName(String value) {
        if (value.length() > CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 됩니다.");
        }
        this.value = value;
    }

    public static CarName of(String value) {
        return new CarName(value);
    }

    public String getCarName() {
        return this.value;
    }
}
