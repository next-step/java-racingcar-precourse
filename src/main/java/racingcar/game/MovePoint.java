package racingcar.game;

public class MovePoint {

    private int movePoint;

    public MovePoint(String movePoint) {
        this.movePoint = convertMovePoint(movePoint);
    }

    private int convertMovePoint(String movePoint) {
        try {
            return Integer.parseInt(movePoint);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(
                    "[ERROR] You cannot change the entered string to a numeric type. Check your input: " + movePoint
            );
        }
    }

    public int getMovePoint() {
        return movePoint;
    }
}
