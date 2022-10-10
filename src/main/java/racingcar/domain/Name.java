package racingcar.domain;

import racingcar.common.Number;
import racingcar.exception.RacingCarIllegalArgumentException;

public class Name {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        checkNameLength(name.trim());
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() == Number.ZERO) {
            throw new RacingCarIllegalArgumentException("자동차 이름은 빈값일 수 없습니다.");
        }

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new RacingCarIllegalArgumentException("자동차 이름은 " + MAX_CAR_NAME_LENGTH + "자 이하만 가능합니다. length:" + name.length());
        }
    }

    public String getName() {
        return name;
    }
}
