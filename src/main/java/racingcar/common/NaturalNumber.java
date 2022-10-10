package racingcar.common;

import racingcar.constant.ErrorConstants;

import java.util.Objects;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_NUMBER_IS_NEGATIVE);
        }
    }

    public boolean isSame(NaturalNumber number) {
        return this.get() == number.get();
    }

    public NaturalNumber plus(NaturalNumber number) {
        return new NaturalNumber(this.get() + number.get());
    }


    public int get() {
        return this.number;
    }

    public boolean isGreaterThan(NaturalNumber number) {
        if (Objects.isNull(number))
            return false;

        return this.get() > number.get();
    }
}
