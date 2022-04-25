package racingcar;

import racingcar.constant.NumberConst;

public class Moving {
    public static boolean isMove(int number) {
        return number >= NumberConst.MIN_MOVE_NUMBER;
    }
}
