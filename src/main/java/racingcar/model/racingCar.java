package racingcar.model;

public class racingCar {
    private racingcarName carName;
    private racingcarPosition position;
    public racingCar(racingcarName carName) {
        this.carName = carName;
        this.position = new racingcarPosition(0);
    }
    public racingcarName getCarNameClass() {
        return carName;
    }
    public racingcarPosition getPositionClass() {
        return position;
    }
}
