package racingcar.model;

import racingcar.exception.RacingGameIllegalArgumentException;

public final class Name {

    private String name;

    private Name() {}

    private Name(String name) {
        this.name = name;
    }

    public static Name valueOf(String carName) {
        validate(carName);
        return new Name(carName);
    }

    private static void validate(String carName) {
        if (carName.length() > 5) {
            throw new RacingGameIllegalArgumentException("5자 이하의 자동차 이름을 입력해주세요.");
        }
    }

    public String get() {
        return this.name;
    }

}
