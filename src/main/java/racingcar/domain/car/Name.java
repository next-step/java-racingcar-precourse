package racingcar.domain.car;

import racingcar.common.error.ErrorMessage;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    private Name(String name) {
        this.name = name;
        validate();
    }

    static public Name from(String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return name;
    }

    private void validate() {
        validateNull();
        validateEmpty();
        validateLength();
    }

    private void validateLength() {
        if (this.name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.MSG_INVALID_OVER_NAME_LENGTH.getMessage(), MAX_NAME_LENGTH));
        }
    }

    private void validateEmpty() {
        if (this.name == null || this.name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.MSG_INVALID_OVER_NAME_EMPTY.getMessage());
        }
    }

    private void validateNull() {
        if (this.name == null) {
            throw new IllegalArgumentException(ErrorMessage.MSG_INVALID_OVER_NAME_NULL.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Name that = (Name) o;
        return name == that.name;
    }
}
