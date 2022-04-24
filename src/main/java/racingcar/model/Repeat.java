package racingcar.model;

import racingcar.constants.RepeatMessage;

public class Repeat {
    private static final String NUMBER_FORMAT_REGEX = "^[1-9]+[0-9]*$";
    private static final int MAX_REPEAT_NUMBER = Integer.MAX_VALUE;
    private static final int BILLION_DIGIT_LENGTH = 10;

    private final int number;

    private Repeat(int number) {
        this.number = number;
    }

    public static Repeat valueOf(String number) {
        validNumberFormat(number);
        validIntegerRange(number);

        return new Repeat(Integer.parseInt(number));
    }

    private static void validNumberFormat(String number) {
        if (!number.matches(NUMBER_FORMAT_REGEX)) {
            throw new IllegalArgumentException(RepeatMessage.INVALID_POSITIVE_NUMBER_FORMAT);
        }
    }

    private static void validIntegerRange(String number) {
        if (isMoreThanBillionDigits(number) || isOutOfRange(Long.parseLong(number))) {
            throw new IllegalArgumentException(RepeatMessage.INVALID_NUMBER_RANGE);
        }
    }

    private static boolean isMoreThanBillionDigits(String number) {
        return number.length() > BILLION_DIGIT_LENGTH;
    }

    private static boolean isOutOfRange(Long number) {
        return number > MAX_REPEAT_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
