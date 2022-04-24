package racingcar.model;

import racingcar.ui.CarStatus;

public class Car {
    private final Name name;
    private final Location location;
    private CarStatus status;

    public Car(String carName) {
        this.name = new Name(carName);
        this.location = new Location();
    }

    public String getName() {
        return name.getName();
    }

    public void addLocation() {
        this.location.setFigure();
    }

    public String getLocation() {
        return location.getProgress();
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public CarStatus getStatus() {
        return status;
    }
}
