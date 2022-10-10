package racingcar.domain;

import java.util.Objects;
import racingcar.message.ErrorMessage;

public class RoundNumber {
    private static final int MIN_NUM = 0;
    private int num;

    public RoundNumber() {
        this.num = 0;
    }

    public RoundNumber(String num) {
        try {
            this.num = Integer.parseInt(num);
            if (this.num < MIN_NUM) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_ROUND_NUMBER_NOT_VALID);
        }
    }

    public boolean isFinalRoundNumber(RoundNumber otherNum) {
        return this.num == otherNum.num;
    }

    public void plus() {
        this.num++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoundNumber that = (RoundNumber) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}