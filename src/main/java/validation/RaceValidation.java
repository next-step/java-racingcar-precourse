package validation;

import message.Message;

public class RaceValidation {
    private static final int MIN_TRY_COUNT = 1;

    public static void raceCountValided(String tryCount)  {
        isNumber(tryCount);
        validTryCount(tryCount);
    }
    private static void isNumber(String tryCount) {
        for (int i = 0; i < tryCount.length(); i++) {
            char number = tryCount.charAt(i);

            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException(Message.ERROR_IS_NOT_NUMBER);
            }
        }
    }

    public static void validTryCount(String tryCount) {
        int number = Integer.parseInt(tryCount);
        if(number < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_TRY_COUNT);
        }
    }
}
