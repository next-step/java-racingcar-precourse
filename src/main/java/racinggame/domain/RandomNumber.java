package racinggame.domain;

import nextstep.utils.Randoms;

public class RandomNumber {
    public int randomNum;

    public RandomNumber() {
        this.randomNum = Randoms.pickNumberInRange(0, 9);
        if (this.randomNum < 0 || this.randomNum > 9) {
            throw new IllegalArgumentException("생성할 랜덤할 숫자는 0에서 9사이여야합니다.");
        }
    }
}
