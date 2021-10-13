package racinggame.validation;

import racinggame.common.Const;

public class RaceValidation {
    public static void raceCountValided(String tryCount)  {
        isNumber(tryCount);
        validTryCount(tryCount);
    }
    protected static boolean isNumber(String tryCount) {
        for (int i = 0; i < tryCount.length(); i++) {
            if (!Character.isDigit(tryCount.charAt(i))) {
                throw new IllegalArgumentException(Const.ERROR_IS_NOT_NUMBER);
            }
        }
        return true;
    }

    protected static boolean validTryCount(String tryCount) {
        int number = Integer.parseInt(tryCount);
        if(number < Const.MIN_TRY_COUNT) {
            throw new IllegalArgumentException(Const.ERROR_TRY_COUNT);
        }
        return true;
    }
}
