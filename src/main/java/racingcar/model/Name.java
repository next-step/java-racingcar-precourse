package racingcar.model;

import racingcar.ErrorMessages;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        this.name = name;
        validate();
    }

    @Override
    public String toString() {
        return this.name;
    }

    private void validate() {
        validateLength();
    }


    private void validateLength() {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.LONG_NAME);
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
