package me.ascii92der.racingcar;

public class Car {

    private final CarName carName;
    private static final int MOVE_JUDGED_NUMBER = 4;
    private int position = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public boolean canMove(int moveNumer) {
        return moveNumer >= MOVE_JUDGED_NUMBER;
    }

    public int moveCar(int moveNumber) {
        if (canMove(moveNumber)) {
            position += 1;
        }
        return position;
    }

}
