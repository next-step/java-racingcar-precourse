package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public boolean isDuplicated(String[] str) {
        Set<String> checkDupclicate = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            checkDupclicate.add(str[i]);
        }
        if (checkDupclicate.size() != str.length) {
            return true;
        }
        return false;
    }
}
