package racinggame;

public class Car {
    private static final int MOVABLE_MINIMUM_NUMBER = 4;

    private String name;
    private MoveStatus moveStatus;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public MoveStatus getMoveStatus() {
        return moveStatus;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void decideMove(int randomNumber) {
        if (isMovable(randomNumber)) {
            moveStatus = MoveStatus.MOVE_FORWARD;
            moveCount++;
            return;
        }

        moveStatus = MoveStatus.STOP;
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_MINIMUM_NUMBER;
    }

    public boolean isMovableForward() {
        return moveStatus.isMoveForward();
    }
}
