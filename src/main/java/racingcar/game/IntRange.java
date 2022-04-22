package racingcar.game;

import racingcar.game.util.AbstractImmutableList;

import java.util.ArrayList;
import java.util.List;

public class IntRange extends AbstractImmutableList<Integer> {
    private IntRange() {
        super();
    }

    public IntRange(int start, int endInclusive) {
        super(range(start, endInclusive));
    }

    public IntRange(int endInclusive) {
        this(1, endInclusive);
    }

    private IntRange(List<Integer> list) {
        super(list);
    }

    private static List<Integer> range(int start, int endInclusive) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= endInclusive; i++) {
            result.add(i);
        }
        return result;
    }

    public IntRange rest() {
        if (list.size() < 1) new IntRange();
        return new IntRange(list.subList(1, list.size()));
    }
}
