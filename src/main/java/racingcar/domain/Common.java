package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.Constant.MOVE_CONDITION;

public class Common {
    public static boolean isEmpty(String target) {
        return target == null || target == "";
    }

    public static int getRandomNumber(int minRaceCount, int maxRaceCount) {
        return Randoms.pickNumberInRange(minRaceCount, maxRaceCount);
    }

    public static boolean overMoveCondition(int randomNumber) {
        return randomNumber > MOVE_CONDITION;
    }
}
