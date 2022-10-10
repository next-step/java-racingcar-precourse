package racingcar;

public class MoveDistance {
    private int moveDistance;

    public MoveDistance() {
        moveDistance = 0;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void increaseDistance() {
        moveDistance++;
    }

    public void saveIfParameterValueGreater(int parameterInt) {
        if (moveDistance < parameterInt) moveDistance = parameterInt;
    }
}
