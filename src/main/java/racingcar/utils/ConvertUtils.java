package racingcar.utils;

import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;
import java.util.List;
import java.util.StringJoiner;

public class ConvertUtils {
    public static int convertRepeatCountToInteger(String repeatCount) {
        try {
            return Integer.parseInt(repeatCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
            );
        }
    }

    public static String convertWinnerNamesListToString(List<String> names) {
        StringJoiner sj = new StringJoiner(StringConst.CHAR_COMMA);
        for (String name : names) {
            sj.add(name);
        }
        return sj.toString();
    }

    public static String convertPositionToHyphenString(String position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(position); i++) {
            sb.append(StringConst.CHAR_HYPHEN);
        }
        return sb.toString();
    }
}
