package racingcar.util;

import racingcar.exception.RacingIllegalArgumentException;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    private final int MIN_CAR_CNT = 2;

    public void hasNotEnoughParticipant(String[] str) {
        if (str.length < MIN_CAR_CNT) {
            throw new RacingIllegalArgumentException("자동차는 최소 2대 이상입니다.");
        }
    }

    public void isDuplicated(String[] str) {
        Set<String> checkDupclicate = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            checkDupclicate.add(str[i].trim());
        }
        if (checkDupclicate.size() != str.length) {
            throw new RacingIllegalArgumentException("입력한 자동차의 이름에 중복된 이름이 있습니다.");
        }
    }
}
