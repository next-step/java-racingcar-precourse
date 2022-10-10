package racingcar.utils;

public class RacingCarUtils {

    public static void checkValidCarNumber(int length) {
        if(!isValidCarLength(length))
            throw new IllegalArgumentException(Message.CAR_NUMBER_EXCEPTION.getMessage()
                    + NumberRule.MIN_CAR_NUMBER.getValue());
    }

    public static boolean isValidCarLength(int length) {
        return length >= NumberRule.MIN_CAR_NUMBER.getValue();
    }

    public static void checkMinTryNumber(int tryNumber) {
        if(!overMinTryNumber(tryNumber))
            throw new IllegalArgumentException(Message.MIN_TRY_NUMBER_EXCEPTION.getMessage()
                    + NumberRule.MIN_TRY_NUMBER.getValue());
    }

    public static boolean overMinTryNumber(int tryNumber) {
        return tryNumber >= NumberRule.MIN_TRY_NUMBER.getValue();
    }
}
