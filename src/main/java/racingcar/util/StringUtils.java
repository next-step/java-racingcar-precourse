package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static List<String> splitByDelimiter(String text, String delimiter) {
        text = text.replaceAll(" ", "");
        String[] splitResultList = text.split(delimiter, -1);
        return Arrays.asList(splitResultList);
    }
}
