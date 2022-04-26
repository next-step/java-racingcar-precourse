package racingcar;

import java.util.Objects;

public class RacingCarName {
    public static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public RacingCarName(String value) {
        if (value.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 넘길 수 없습니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarName that = (RacingCarName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "RacingCarName{" +
                "value='" + value + '\'' +
                '}';
    }
}
