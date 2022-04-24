package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    private final int MIN_CAR_CNT = 2;

    public boolean hasNotEnoughParticipant(String[] str) {
        if (str.length < MIN_CAR_CNT) {
            return true;
        }
        return false;
    }

    public boolean isDuplicated(String[] str) {
        Set<String> checkDupclicate = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            checkDupclicate.add(str[i].trim());
        }
        if (checkDupclicate.size() != str.length) {
            return true;
        }
        return false;
    }
}
