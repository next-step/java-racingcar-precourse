package racinggame;

public class Car {
    private static final int MOVABLE_MINIMUM_NUMBER = 4;

    private final CarName carName;
    private MoveStatus moveStatus;
    private CarMoveCount carMoveCount;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.carMoveCount = new CarMoveCount(0);
    }

    public String getName() {
        return carName.getName();
    }

    public MoveStatus getMoveStatus() {
        return moveStatus;
    }

    public int getMoveCount() {
        return carMoveCount.getMoveCount();
    }

    public void decideMove(int randomNumber) {
        if (isMovableNumber(randomNumber)) {
            moveStatus = MoveStatus.MOVE_FORWARD;
            carMoveCount.increaseMoveCount();
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
        return getMoveCount() == maximumCount;
    }

    @Override
    public String toString() {
        return Message.printCarSpecification(getName(), getMoveCount());
    }

}
