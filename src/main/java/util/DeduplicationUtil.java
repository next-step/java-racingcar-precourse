package util;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeduplicationUtil {
    public static String[] deduplication(String[] array) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(array));
        return set.toArray(new String[0]);
    }
}
