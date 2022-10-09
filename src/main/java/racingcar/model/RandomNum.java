package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    private int num;

    public RandomNum() {
        generate();
    }

    public RandomNum(int randomNumInput) {
        if (validate(randomNumInput)) {
            this.num = randomNumInput;
            return;
        }
        generate();
    }

    private void generate() {
        num = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (!validate(num)) {
            generate();
        }
    }

    private boolean validate(int randomNum) {
        return randomNum >= START_INCLUSIVE && randomNum <= END_INCLUSIVE;
    }

    public int getNum() {
        return num;
    }
}