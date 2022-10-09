package racingcar.utils;

import java.util.List;
import java.util.StringJoiner;

public final class StringUtils {

    public static String convertListToString(List<String> stringList, String delimiter) {
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        for(String str: stringList) {
            stringJoiner.add(str);
        }
        return stringJoiner.toString();
    }

    public static String[] convertStringToArray(String regex, String delimiter) {
        return regex.split(delimiter);
    }
}
