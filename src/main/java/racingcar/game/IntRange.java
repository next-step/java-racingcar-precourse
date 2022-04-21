package racingcar.game;

import racingcar.game.util.AbstractMutableList;

import java.util.List;

public class IntRange extends AbstractMutableList<Integer> {
    public IntRange() {
        super();
    }

    public IntRange(int start, int endInclusive) {
        for (int i = start; i <= endInclusive; i++) {
            add(i);
        }
    }

    private IntRange(List<Integer> list) {
        super(list);
    }

    public IntRange rest() {
        if (list.size() < 1) new IntRange();
        return new IntRange(list.subList(1, list.size()));
    }
}
