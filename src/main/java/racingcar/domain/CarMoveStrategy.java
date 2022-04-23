package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveStrategy implements MoveStrategy {

    public static final int MOVABLE_NUM = 4;

    @Override
    public boolean movable() {
        return RandomNumber.generate() >= MOVABLE_NUM;
    }
}
