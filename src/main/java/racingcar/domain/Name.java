package racingcar.domain;

import racingcar.exception.NameHasInvalidCharacterException;
import racingcar.exception.NameHasInvalidLengthException;

import java.util.Objects;

import static racingcar.domain.rule.RacingCarGameRule.*;

public class Name {

    private String name;

    public Name(String name) {
        checkLength(name);
        checkInvalidCharacter(name);
        this.name = name;
    }

    private void checkLength(String name) {
        if (name.length() < MIN_LENGTH_OF_NAME || name.length() > MAX_LENGTH_OF_NAME) {
            throw new NameHasInvalidLengthException();
        }
    }

    private void checkInvalidCharacter(String name) {
        if (name.indexOf(SEPERATOR) >= 0) {
            throw new NameHasInvalidCharacterException();
        }
    }

    public int getLength() {
        return name == null ? 0 : name.length();
    }

    public String asString() {
        return name == null ? "" : name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }
}
