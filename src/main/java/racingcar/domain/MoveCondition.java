package racingcar.domain;

import racingcar.domain.util.RandomIntegerProvider;

import static racingcar.domain.constant.RacingCarConstant.*;

public class MoveCondition {

    private MoveCondition() {
    }

    public static Distance getDistance() {
        RandomIntegerProvider randomIntegerProvider = new RandomIntegerProvider();
        int randomNumber = randomIntegerProvider.provideRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomNumber < MINIMUM_MOVABLE_NUMBER) {
            randomNumber = 0;
        }
        return new Distance(randomNumber);
    }

}
