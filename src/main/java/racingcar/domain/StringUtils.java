package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;

public final class StringUtils {
    public static final String COMMA = ",";

    public static String[] splitByComma(String text) {
        return text.split(COMMA);
    }

    public static String joinByComma(List<String> texts) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String text : texts) {
            stringJoiner.add(text);
        }
        return stringJoiner.toString();
    }
}
