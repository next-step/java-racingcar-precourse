package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ViewMessage;
import racingcar.dto.RandomIntegers;

import java.util.LinkedList;
import java.util.List;

public class RandomIntegerGenerator {
    private final int inclusiveStart;
    private final int inclusiveEnd;

    public RandomIntegerGenerator(int inclusiveStart, int inclusiveEnd) {
        if (inclusiveStart > inclusiveEnd) {
            throw new IllegalArgumentException(ViewMessage.END_VALUE_CANNOT_BE_LESS_THAN_START_VALUE);
        }
        this.inclusiveStart = inclusiveStart;
        this.inclusiveEnd = inclusiveEnd;
    }

    public int pickRandomIntegerInRange() {
        return Randoms.pickNumberInRange(getInclusiveStart(), getInclusiveEnd());
    }

    public RandomIntegers pickRandomIntegersInRange(int count) {
        if (count == 0) {
            throw new IllegalArgumentException(ViewMessage.MUST_GENERATE_AT_LEAST_ONE_NUMBER);
        }
        List<Integer> integers = new LinkedList<>();
        for (int idx = 0; idx < count; idx++) {
            int integer = pickRandomIntegerInRange();
            integers.add(integer);
        }
        return new RandomIntegers(integers);
    }

    private int getInclusiveStart() {
        return this.inclusiveStart;
    }

    private int getInclusiveEnd() {
        return this.inclusiveEnd;
    }
}
