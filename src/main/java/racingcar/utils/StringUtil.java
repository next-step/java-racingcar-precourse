package racingcar.utils;

import racingcar.constant.Constant;

import java.util.List;

public class StringUtil {

    public static String repeat(String s, int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static String joinWithComma(List<String> stringList) {
        return String.join(Constant.COMMA, stringList);
    }
}
