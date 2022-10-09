package racingcar.model;

public class Name {
    private static final String ERROR_INVALID_LENGTH = "자동차 이름은 5자 이하여야 합니다.";
    private static final String ERROR_NULL = "자동차 이름은 null 이 될 수 없습니다.";
    private static final Integer LIMIT_LENGTH = 5;
    private static final int ZERO = 0;

    private final String carName;

    public Name(String carName) {
        validateName(carName);
        this.carName = carName;
    }

    private void validateName(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ERROR_NULL);
        }
        if (input.length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_LENGTH);
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.length() == ZERO;
    }

    public String getCarName() {
        return carName;
    }
}

