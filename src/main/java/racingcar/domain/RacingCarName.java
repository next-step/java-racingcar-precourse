package racingcar.domain;

import racingcar.util.Assert;

public class RacingCarName {

    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    public RacingCarName(final String name) {
        Assert.notNull(name, "자동차의 이름은 필수 값입니다.");
        Assert.notLessThan(name.trim().length(), MINIMUM_LENGTH, "자동차의 이름은 1자 이상이어야 합니다.");
        Assert.notMoreThan(name.trim().length(), MAXIMUM_LENGTH, "자동차의 이름은 5자 이하이어야 합니다.");

        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
