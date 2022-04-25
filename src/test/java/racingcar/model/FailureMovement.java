package racingcar.model;

public class FailureMovement implements MovementCondition {
    @Override
    public int moving() {
        return 3;
    }
}
