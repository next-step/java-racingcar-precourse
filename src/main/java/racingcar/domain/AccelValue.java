package racingcar.domain;

import racingcar.common.NaturalNumber;
import racingcar.constant.AccelRange;
import racingcar.constant.ErrorConstants;

public class AccelValue {

    private final int accel;

    private AccelValue(int accel) {
        this.accel = accel;
    }

    public static AccelValue of(Integer accel) {
        validate(accel);
        return new AccelValue(accel);
    }

    private static void validate(Integer accel) {
        isNull(accel);
        isInValidRange(accel);
    }

    private static void isInValidRange(Integer accel) {
        if (accel < AccelRange.MIN_ACCEL_VALUE || accel > AccelRange.MAX_ACCEL_VALUE) {
            throw new IllegalArgumentException(getNotInRangeErrorMessage());
        }
    }

    private static String getNotInRangeErrorMessage() {
        return String.format("%s(%s~%s)", ErrorConstants.ERROR_ACCEL_IS_NOT_IN_RANGE, AccelRange.MIN_ACCEL_VALUE, AccelRange.MAX_ACCEL_VALUE);
    }

    private static void isNull(Integer accel) {
        if (accel == null) {
            throw new IllegalArgumentException();
        }
    }

    public NaturalNumber get() {
        return NaturalNumber.of(this.accel);
    }

    public boolean isLowerThan(int minForwardAccel) {
        return this.accel < minForwardAccel;
    }

    public boolean isEqualOrGreaterThan(int minForwardAccel) {
        return this.accel >= minForwardAccel;
    }
}
