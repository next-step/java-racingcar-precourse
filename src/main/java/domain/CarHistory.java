package domain;

public class CarHistory {
    private CarName carName;
    private Position position;

    public CarHistory(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
