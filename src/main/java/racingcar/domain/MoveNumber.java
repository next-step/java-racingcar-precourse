package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveNumber {
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    private final int moveNumber;

    public MoveNumber() {
        this(getMoveNumberRandomly());
    }

    private static int getMoveNumberRandomly() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    private MoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public int getMoveNumber() {
        return moveNumber;
    }
}
