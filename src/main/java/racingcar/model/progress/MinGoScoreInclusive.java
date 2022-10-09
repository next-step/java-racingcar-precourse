package racingcar.model.progress;

import racingcar.model.cars.factory.MoveEvent;

public class MinGoScoreInclusive {
    private final int minGoScoreInclusive;

    public MinGoScoreInclusive(int minGoScoreInclusive) {
        this.minGoScoreInclusive = minGoScoreInclusive;
    }

    public boolean isGo(MoveEvent event) {
        return event.get() >= minGoScoreInclusive;
    }

    public int get() {
        return minGoScoreInclusive;
    }
}
