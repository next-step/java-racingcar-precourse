package racingCar.domain;

public class Car {

    private final Name name;
    private Position position;

    public Car(String carName, int position) {
        this.name = new Name(carName);
        this.position = new Position(position);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public TryResult move(MovableStrategy movable) {
        if (movable.movable()) {
            this.position = this.position.move();
        }
        return new TryResult(name.getName(), position.getPosition());
    }
}
