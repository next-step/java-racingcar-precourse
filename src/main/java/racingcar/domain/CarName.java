package racingcar.domain;

public class CarName {
    private static final String INVALID_CAR_NAME = "자동차 이름은 5글자를 초과할 수 없습니다.";
    private static final String INVALID_CAR_NAME_EMPTY = "자동차 이름은 1글자 이상이어야 합니다.";
    private static final int MAX_CAR_NAME_SIZE = 5;
    private final String name;

    public CarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_EMPTY);
        }
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
