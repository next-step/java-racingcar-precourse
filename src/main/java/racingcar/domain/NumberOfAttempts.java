package racingcar.domain;

import static racingcar.constant.ErrorStatus.NUMBER_OF_ATTEMPTS_SMALLER_THAN_ONE;

public class NumberOfAttempts {
    private int number;

    public NumberOfAttempts(int number) {
        validate(number);
        this.number = number;
    }

    public void subtract() {
        this.number--;
    }

    public boolean areRemain() {
        return number > 0;
    }

    private void validate(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_SMALLER_THAN_ONE.getMessage());
        }
    }

}
