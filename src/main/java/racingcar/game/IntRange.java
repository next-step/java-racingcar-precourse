package racingcar.game;

import racingcar.game.util.AbstractMutableList;

public class IntRange extends AbstractMutableList<Integer> {
    public IntRange(int start, int endInclusive) {
        for (int i = start; i <= endInclusive; i++) {
            add(i);
        }
    }
}
