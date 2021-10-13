package racinggame.domain.utils;

import racinggame.domain.constants.Numbers;

import static racinggame.domain.constants.Delimters.COMMA;
import static racinggame.domain.constants.Delimters.COMMA_REGULAR;

public class ValidationUtils {



    public static boolean validCarName(String input) {
        return input.length() >= Numbers.MIN_NO  && input.length() <= Numbers.MAX_CAR_NAME_LENGTH;
    }

    public static boolean validSplitableCarNames(String input) {
        if(!input.contains(COMMA)) return false;
        String[] carsArray = input.trim().split(COMMA_REGULAR);

        for (String carName : carsArray) {
            if(!validCarName(carName)) return false;
        }

        return input.split(COMMA).length >= Numbers.MIN_NO;
    }

    public static boolean validNumbersBetweenOneAndNine(int random) {
        return random >= Numbers.MIN_NO  && random <= Numbers.MAX_NO;
    }

    public static boolean validGameRound(String gameRound) {
        boolean isParsable = true;
        try{
            Integer.parseInt(gameRound);
        }catch (NumberFormatException ex) {
            isParsable = false;
        }
        return isParsable;
    }
}
