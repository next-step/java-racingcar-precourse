package racingcar.feature;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 난수 생성기
 */
public class RandomGenerator {

    /**
     * @return 난수 생성
     */
    public static int generate(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
