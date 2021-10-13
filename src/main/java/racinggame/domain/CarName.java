package racinggame.domain;

import java.util.Objects;

public class CarName {
    private static final String EMPTY_STRING = "";
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;
    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void validate(String carName) {
        String trimmedCarName = trim(carName);
        if (isInvalidCarName(trimmedCarName)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 1~5자 사이의 값만 허용됩니다");
        }
    }

    private static String trim(String value) {
        if (value == null) {
            return EMPTY_STRING;
        }
        return value.trim();
    }

    private static boolean isInvalidCarName(String trimmedCarName) {
        if (trimmedCarName.isEmpty()) {
            return true;
        }
        return trimmedCarName.length() > MAX_LENGTH_OF_CAR_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
