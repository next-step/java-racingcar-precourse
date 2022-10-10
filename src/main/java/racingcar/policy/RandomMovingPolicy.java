package racingcar.policy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RandomNumber;

public class RandomMovingPolicy implements MovingPolicy {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    @Override
    public boolean isMovable() {
        return new RandomNumber(generateRandomNumber()).isMovable();
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

}
