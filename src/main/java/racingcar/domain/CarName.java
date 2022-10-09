package racingcar.domain;

import java.util.Objects;

public class CarName {

    private final String WHITESPACE = " ";
    private final int MIN_NAME_LENGTH = 1;
    private final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        if (validateWhitespace(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백을 제외하고 작성이 가능합니다.");
        }
        if (validateCarName(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 한글자 이상 다섯글자 이하만 가능합니다.");
        }
        this.name = name;
    }

    private boolean validateCarName(final String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    private boolean validateWhitespace(final String name) {
        return name.contains(WHITESPACE);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(getName(), carName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
