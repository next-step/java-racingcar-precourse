package main.java.racingcar.domain;

public class Car {

    public static final String CAR_POSITION_SIGN = "-";
    public static final int START_POSITION = 0;
    private final CarName name;
    private final int speed;
    private final Position position;
    public Car(CarName carName) {
        this.name = carName;
        this.speed = 1;
        this.position = new Position(START_POSITION);
    }

    public void moveForwardIfTrue(boolean isForward) {
        if(isForward) {
            this.position.increment(speed);
        }
    }

    public boolean isSamePosition(int position) {
        return this.position.getAmount() == position;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getAmount();
    }

    @Override
    public String toString() {
        return this.name.getName() + " : " + this.CAR_POSITION_SIGN.repeat(this.position.getAmount());
    }
}
