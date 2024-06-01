package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSplitter {

    private static final String DELIMITER = ",";

    private StringSplitter() {}

    public static List<String> splitString(String input) {
        List<String> result = new ArrayList<>();
        Collections.addAll(result, input.split(DELIMITER));
        return result;
    }
}
