package racingcar.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Move {
    public static final int BASE_NUM = 4;

    public boolean isCarMove(int number) {
        if (number < BASE_NUM)
            return false;
        return true;
    }
    public int getRandomNumber(int start, int end) {
        return pickNumberInRange(start,end);
    }
}
