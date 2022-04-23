package racingcar.nextstep.domain.car;

public class CarName {

    private final String value;

    public CarName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CarName of(String value) {
        return new CarName(value);
    }
}
