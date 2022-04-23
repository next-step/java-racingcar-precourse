package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    private static final int RANDOM_START_NUM = 0;
    private static final int RANDOM_END_NUM = 9;
    private static final int RANDOM_NUM_PIVOT = 4;
    private final int number;

    public RandomNum() {
        this.number = Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_END_NUM);
        validRandomNum();
    }

    public static RandomNum generateRandomNum() {
        return new RandomNum();
    }

    private void validRandomNum() {
        if (this.number < RANDOM_START_NUM || this.number > RANDOM_END_NUM) {
            throw new IllegalStateException("랜덤 값이 유효하지 않습니다.");
        }
    }

    public boolean isMoreNumber() {
        return number >= RANDOM_NUM_PIVOT;
    }

    public int getNumber() {
        return this.number;
    }
}
