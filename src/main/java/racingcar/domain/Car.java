package racingcar.domain;

public class Car {

    private final CarName carName;
    private final Position position;

    private Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car release(String name) {
        return new Car(new CarName(name), new Position());
    }

    public void move(int randomNumber) {
        this.position.moveForward(randomNumber);
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
