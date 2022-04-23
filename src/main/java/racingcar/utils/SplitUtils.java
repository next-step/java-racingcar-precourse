package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class SplitUtils {

    private SplitUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> splitToList(String words, String delimiter) {
        List<String> wordList = Arrays.asList(words.split(delimiter));
        return wordList;
    }
}
