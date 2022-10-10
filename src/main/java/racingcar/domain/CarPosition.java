package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarPosition {
    private static final int NUMBER_RANGE_START = 0;
    private static final int NUMBER_RANGE_END = 9;
    private static final int FORWARD_CONDITION = 4;

    private int position = 0;

    public void forward() {
        int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);

        if (validateForward(randomNumber)) {
            this.position++;
        }
    }

    public void forward(int number) {
        if (validateForward(number)) {
            this.position++;
        }
    }

    private boolean validateForward(int number) {
        return number >= FORWARD_CONDITION;
    }

    public int getPosition() {
        return position;
    }
}
