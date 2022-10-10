package racingcar.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.util.Constans.MAX_RANDOM_NUM;
import static racingcar.util.Constans.MIN_RANDOM_NUM;

public class RandomNumber {
    public int getNumber() {
        return pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }
}
