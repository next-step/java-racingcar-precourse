package racinggame;

public class Car {
    private Position position;
    private CarName carName;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getCarName() {
        return carName.getValue();
    }
}
