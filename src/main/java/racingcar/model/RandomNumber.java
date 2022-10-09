package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameEnvironment;

public class RandomNumber {
    public static int generate() {
        return Randoms.pickNumberInRange(GameEnvironment.MIN_RANDOM_NUMBER, GameEnvironment.MAX_RANDOM_NUMBER);
    }
}
