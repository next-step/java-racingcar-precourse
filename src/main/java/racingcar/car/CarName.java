package racingcar.car;

import java.util.Objects;

class CarName {

    static final int MAX_LENGTH = 5;

    private final String value;

    protected CarName(String value) {
        this.value = validate(value);
    }

    public static CarName of(String value) {
        return new CarName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static String validate(String value) {
        if (value == null) {
            throw new InvalidCarNameException(null);
        }
        value = value.trim();
        if (value.isEmpty() || value.length() > MAX_LENGTH) {
            throw new InvalidCarNameException(value);
        }
        return value;
    }
}
