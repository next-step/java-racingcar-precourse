package racingcar.common;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomGenerator {
    private int min;
    private int max;

    public RandomGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int generate() {
        return pickNumberInRange(min, max);
    }
}
