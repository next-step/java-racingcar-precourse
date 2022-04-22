package racingcar.domain;

public class CarName {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String OVER_SIZE_EXCEPTION_MESSAGE = "[ERROR] 이름은 5자리 이하만 가능합니다.";

    private final String name;

    public CarName(String name) {
        validateNameSize(name);
        this.name = name;
    }

    private void validateNameSize(String name) {
        if (isFiveDigitsOrLess(name)) {
            throw new IllegalArgumentException(OVER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isFiveDigitsOrLess(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return name;
    }
}
