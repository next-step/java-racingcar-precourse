package racingcar.game.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public final class Random {
    public static int randomInt(int start, int end) {
        return pickNumberInRange(start, end);
    }
}
