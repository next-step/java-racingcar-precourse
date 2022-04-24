package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberCreator {
    public static Integer makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
