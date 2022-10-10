package racingcar.model;

import racingcar.code.NameErrorCode;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        nameNull(name);
        nameEmpty(name);
        nameLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void nameLength(final String name) {
        if(name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NameErrorCode.LENGTH.getMessage());
        }
    }

    private void nameNull(final String name) {
        if(isNull(name)) {
            throw new IllegalArgumentException(NameErrorCode.NULL.getMessage());
        }
    }

    private void nameEmpty(final String name) {
        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException(NameErrorCode.EMPTY.getMessage());
        }
    }

    private boolean isNull(final String name) {
        return name == null || name.length() == 0;
    }
}
