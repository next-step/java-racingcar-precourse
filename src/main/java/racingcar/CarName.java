package racingcar;

public class CarName {
    public static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            String message = String.format("자동차 이름은 %d글자 이하만 가능합니다.: %s", CAR_NAME_MAX_LENGTH, name);
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
