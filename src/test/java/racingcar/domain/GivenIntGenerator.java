package racingcar.domain;

import racingcar.domain.car.RandomIntGenerator;

public class GivenIntGenerator implements RandomIntGenerator {
    private final int givenInt;

    public GivenIntGenerator(int givenInt) {
        this.givenInt = givenInt;
    }

    @Override
    public int generate() {
        return this.givenInt;
    }
}
