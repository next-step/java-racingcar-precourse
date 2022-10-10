package racingcar.domain;

public class CarName {
    
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (!isValidLength(name)) {
            throw new IllegalArgumentException(
                    ErrorMessage.OUT_OF_RANGE_NAME_ERROR.getMessage(MIN_LENGTH, MAX_LENGTH));
        }
    }

    private boolean isValidLength(String name) {
        return (name.length() >= MIN_LENGTH && name.length() <= MAX_LENGTH);
    }
}
