package racinggame.domain;

import nextstep.utils.Randoms;

public class RandomNumber {
    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 9;
    public int randomNum;

    public RandomNumber() {
        this.randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        if (this.randomNum < MIN_NUM || this.randomNum > MAX_NUM) {
            throw new IllegalArgumentException("생성할 랜덤할 숫자는 0에서 9사이여야합니다.");
        }
    }
}
