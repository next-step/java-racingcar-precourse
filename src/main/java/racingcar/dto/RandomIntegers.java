package racingcar.dto;

import racingcar.constant.ViewMessage;

import java.util.List;

public class RandomIntegers {
    private List<Integer> integers;

    public RandomIntegers(List<Integer> integers) {
        if (integers == null) {
            throw new NullPointerException(ViewMessage.AT_LEAST_ONE_NUMBER_MUST_BE_GENERATED);
        }
        this.integers = integers;
    }

    public int get(int idx) {
        if (idx >= size()) {
            throw new IndexOutOfBoundsException(ViewMessage.INDEX_IS_NOT_AVAILABLE);
        }
        return this.integers.get(idx);
    }

    public int size() {
        return this.integers.size();
    }
}
