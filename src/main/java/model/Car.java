package model;

public class Car {
    private CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void move(MoveJudgmentNumber moveJudgmentNumber) {
        if (moveJudgmentNumber.canMoving()) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
