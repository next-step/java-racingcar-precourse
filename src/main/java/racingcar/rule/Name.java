package racingcar.rule;

public class Name {
    private final String value;

    public Name(String name) {
        final String trimName = name.trim();
        validateMinLength(trimName);
        validateMaxLength(trimName);
        this.value = trimName;
    }

    private void validateMinLength(String name) {
        final int MIN_LENGTH = 1;
        if (name.length() < MIN_LENGTH) {
            final String message = String.format("자동차 이름은 %d자 이상이어야 한다.", MIN_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateMaxLength(String name) {
        final int MAX_LENGTH = 5;
        if (name.length() > MAX_LENGTH) {
            final String message = String.format("자동차 이름은 %d자 이하여야 한다.", MAX_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

    public String get() {
        return value;
    }
}
