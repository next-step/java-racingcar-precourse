package racingcar.move;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement implements Movement {

    private final static int MIN_VALUE = 0;
    private final static int MAX_VALUE = 9;
    private final static int STANDARD_VALUE = 3;
    private final static int INCREASE_VALUE = 1;

    @Override
    public boolean isMoveAble() {
        int randomValue = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        return randomValue > STANDARD_VALUE;
    }

    @Override
    public int getIncreasePosition(int position) {
        return position + INCREASE_VALUE;
    }
}
