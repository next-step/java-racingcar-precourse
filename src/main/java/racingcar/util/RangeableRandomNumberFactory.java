package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RangeableRandomNumberFactory extends AbstractRandomNumberFactory {

    public static final int DEFAULT_MIN_RANDOM_NUMBER = 0;
    public static final int DEFAULT_MAX_RANDOM_NUMBER = 9;

    private final int max;
    private final int min;

    public RangeableRandomNumberFactory(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public RangeableRandomNumberFactory() {
        this.max = DEFAULT_MAX_RANDOM_NUMBER;
        this.min = DEFAULT_MIN_RANDOM_NUMBER;
    }

    @Override
    public AbstractRandomNumber produce() {
        int randomNumber = Randoms.pickNumberInRange(min, max);

        return new RangeableRandomNumber(randomNumber, max, min);
    }

}
