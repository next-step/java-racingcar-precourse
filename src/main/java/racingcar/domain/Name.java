package racingcar.domain;

import racingcar.common.ErrorMessage;
import racingcar.common.ValidUtils;

public class Name {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        if (ValidUtils.stringEmptyValid(name)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_EMPTY.toString());
        }

        if (ValidUtils.stringGreaterThenMaxLength(name, MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_GREATER_THEN_MAX_LENGTH.toString());
        }
    }


    @Override
    public String toString() {
        return name;
    }
}
