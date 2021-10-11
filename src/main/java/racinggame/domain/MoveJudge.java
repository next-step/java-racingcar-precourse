package racinggame.domain;

import nextstep.utils.Randoms;

public class MoveJudge {
    private static final int MOVE_JUDGE_VALUE = 4;
    private static final int RANDOM_MIN_RANGE = 0;
    private static final int RANDOM_MAX_RANGE = 9;

    private MoveJudge() {}

    public static MoveStatus judge() {
        int judgeValue = generateRandomNumber();

        if (judgeValue >= MOVE_JUDGE_VALUE) {
            return MoveStatus.MOVE;
        }

        return MoveStatus.STOP;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE);
    }
}
