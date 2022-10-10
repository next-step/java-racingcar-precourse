package racingcar.domain.car;

import java.util.Objects;
import racingcar.contant.ExceptionMessage;

public class Name {
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name from(String value) {
        validateCarName(value);
        return new Name(value);
    }

    private static void validateCarName(String value) {
        if (value.length() < CAR_NAME_MIN_LENGTH || value.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME);
        }
    }

    public String name() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
