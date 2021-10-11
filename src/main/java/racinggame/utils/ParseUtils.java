package racinggame.utils;

import racinggame.consts.Const;
import racinggame.enums.ErrorMessageEnum;

public class ParseUtils {

    private ParseUtils() {

    }

    public static String[] parseByClassification(String input) {
        return input.split(Const.USER_INPUT_CLASSIFICATION);
    }

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageEnum.INVALID_TRY_COUNT_ERROR.getMessage());
        }

    }
}
