package model;

public class Car {
    private final CarName carName;
    private int position;

    public Car(String name) {
        this.carName = new CarName(name);
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
}
