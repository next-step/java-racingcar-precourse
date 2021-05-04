package racingCar.domain;

public class Car {

    private final Name carName;
    private Position position;

    public Car(String carName, int position) {
        this.carName = new Name(carName);
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    public void move(MovableStrategy movable) {
        if (movable.movable()) {
            this.position = this.position.move();
        }
    }
}
