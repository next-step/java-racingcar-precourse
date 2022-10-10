package racingcar.domain.car.move;

public class DefaultMove implements Move {

    private static final int MOVE_FORWARD_THRESHOLD = 4;
    StringBuilder move;

    public DefaultMove() {
        this.move = new StringBuilder();
    }

    @Override
    public String move(int random) {
        if (random >= MOVE_FORWARD_THRESHOLD) {
            move.append(MOVE_FORWARD);
        }
        return move.toString();
    }

    @Override
    public int moveCount() {
        return move.length();
    }
}
