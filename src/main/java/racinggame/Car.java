package racinggame;

public class Car {
    private static final int MOVABLE_MINIMUM_NUMBER = 4;

    private final String name;
    private MoveStatus moveStatus;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MoveStatus getMoveStatus() {
        return moveStatus;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void decideMove(int randomNumber) {
        if (isMovableNumber(randomNumber)) {
            moveStatus = MoveStatus.MOVE_FORWARD;
            moveCount++;
            return;
        }

        moveStatus = MoveStatus.STOP;
    }

    private boolean isMovableNumber(int number) {
        return number >= MOVABLE_MINIMUM_NUMBER;
    }

    public boolean isMovableForwardStatus() {
        return moveStatus.isMoveForward();
    }

    public boolean isMaximumMoveCount(int maximumCount) {
        return moveCount == maximumCount;
    }

    @Override
    public String toString() {
        return Message.printCarSpecification(name, moveCount);
    }

}
