package racingcar.domain;

public class NumberComparingMoveCondition implements MoveCondition {

    private static final int MINIMUM_SATISFACTION_NUMBER = 4;

    private final int number;

    public NumberComparingMoveCondition(final int number) {
        this.number = number;
    }

    @Override
    public boolean isSatisfied() {
        return number >= MINIMUM_SATISFACTION_NUMBER;
    }
}
