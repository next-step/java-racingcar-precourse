package racingcar.strategy;

public class AlwaysMove implements Move {

    private static final int MOVE_DISTANCE = 1;

    @Override
    public int move(final int currentDistance) {
        return currentDistance + MOVE_DISTANCE;
    }
}
