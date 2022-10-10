package racingcar.type;

import static racingcar.type.ErrorMessageType.GREATER_THAN_END_INCLUSIVE;
import static racingcar.type.ErrorMessageType.LESS_THAN_START_INCLUSIVE;

public enum NumberRangeType {
    START_INCLUSIVE(0),
    END_INCLUSIVE(9);

    private final int number;

    NumberRangeType(final int number) {
        this.number = number;
    }

    public static void validateRange(final int number) {
        if (number < START_INCLUSIVE.getNumber()) {
            throw new IllegalArgumentException(LESS_THAN_START_INCLUSIVE.getMessage());
        }
        if (number > END_INCLUSIVE.getNumber()) {
            throw new IllegalArgumentException(GREATER_THAN_END_INCLUSIVE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
