package racingcar.domain;

import racingcar.exception.NameException;

import java.util.Objects;

import static racingcar.domain.constant.RacingCarConstant.*;

public class CarName {

    private String name;

    public CarName(String name) {
        checkLength(name);
        checkInvalidCharacter(name);
        this.name = name;
    }

    private void checkLength(String name) {
        if (name.length() < MIN_LENGTH_OF_NAME || name.length() > MAX_LENGTH_OF_NAME) {
            throw new NameException.InvalidLengthException();
        }
    }

    private void checkInvalidCharacter(String name) {
        if (name.indexOf(SEPARATOR) >= 0) {
            throw new NameException.InvalidCharacterException();
        }
    }

    public int getLength() {
        return name == null ? 0 : name.length();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(name, carName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
