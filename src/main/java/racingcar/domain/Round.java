package racingcar.domain;

import racingcar.utils.Validation;

public class Round {
    private int count;

    public int getCount() {
        return this.count;
    }

    public void generateRound(String count) {
        Validation.isNumeric(count);
        this.count = Integer.parseInt(count);
    }
}
