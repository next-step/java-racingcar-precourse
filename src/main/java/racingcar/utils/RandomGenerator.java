package racingcar.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomGenerator {
    private final Integer generatedNumber;

    public RandomGenerator() {
        this.generatedNumber = pickNumberInRange(Constants.RANDOM_MIN_NUMBER, Constants.RANDOM_MAX_NUMBER);
    }

    public RandomGenerator(Integer fixedNumber) {
        this.generatedNumber = fixedNumber;
    }

    public Integer getGeneratedNumber() {
        return generatedNumber;
    }
}
