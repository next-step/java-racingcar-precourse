package model;

public class Car {
    private static final int ZERO = 0;

    private final CarName carName;
    private int position;

    public Car(String name) {
        this.carName = new CarName(name);
        position = ZERO;
    }

    public void move(MoveJudgmentNumber moveJudgmentNumber) {
        if (moveJudgmentNumber.canMoving()) {
            this.position++;
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int maxPosition) {
        return this.position == maxPosition;
    }
}
