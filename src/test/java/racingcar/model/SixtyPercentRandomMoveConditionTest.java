package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class SixtyPercentRandomMoveConditionTest {

    private static final SixtyPercentRandomMoveCondition condition = new SixtyPercentRandomMoveCondition();

    @RepeatedTest(value = 10)
    void nearlySixtyPercentMovable() {
        final int testNum = (int) Math.pow(10, 6);
        final boolean[] result = new boolean[testNum];
        for (int i = 0; i < result.length; i++) {
            result[i] = condition.isMovable();
        }

        int movableCount = 0;
        int nonMovableCount = 0;
        for (final boolean isMovable : result) {
            if (isMovable) {
                movableCount++;
                continue;
            }
            nonMovableCount++;
        }

        final Double movablePercent = ((double) movableCount / testNum) * 100;
        final Double nonMovablePercent = ((double) nonMovableCount / testNum) * 100;
        assertThat(movablePercent.compareTo(nonMovablePercent)).isEqualTo(1);
        assertThat(movablePercent).isGreaterThanOrEqualTo(Double.valueOf(55));
        assertThat(nonMovablePercent).isLessThanOrEqualTo(Double.valueOf(45));
    }
}