package racingcar;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> splitComma(String str) {
        return Arrays.asList(str.split(","));
    }

    public static String joinComma(List<String> array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append(array.get(i));

            if (i != (array.size() - 1)) {
                stringBuilder.append(",");
            }
        }

        return stringBuilder.toString();
    }
}
