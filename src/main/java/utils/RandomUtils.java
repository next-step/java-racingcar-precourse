package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static int makeRandom(){
        return Randoms.pickNumberInRange(MIN, MAX);
    }

}
