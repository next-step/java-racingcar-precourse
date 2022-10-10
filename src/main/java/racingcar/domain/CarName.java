package racingcar.domain;

import static racingcar.domain.RacingCarRule.CAR_NAME_LENGTH;
import static racingcar.domain.RacingCarRule.NAME_LENGTH_EXCEPTION;
import static racingcar.domain.RacingCarRule.NAME_NULL_EXCEPTION;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (nameIsNull(name) || nameIsEmpty(name) || nameIsWhitespace(name)) {
            throw new IllegalArgumentException(NAME_NULL_EXCEPTION);
        } else if (nameIsOverLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION);
        }
        this.name = name;
    }

    private boolean nameIsNull(String name) {
        return name == null;
    }

    private boolean nameIsEmpty(String name) {
        return name.isEmpty();
    }

    private boolean nameIsWhitespace(String name) {
        return name.equals(" ");
    }

    private boolean nameIsOverLength(String name) {
        return name.length() > CAR_NAME_LENGTH;
    }

    public String getName() {
        return this.name;
    }
}
