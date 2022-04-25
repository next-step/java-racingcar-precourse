package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class SplitUtils {

    private SplitUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static List<String> splitToList(String words, String delimiter) {
        List<String> wordList = Arrays.asList(words.split(delimiter));
        return wordList;
    }
}
