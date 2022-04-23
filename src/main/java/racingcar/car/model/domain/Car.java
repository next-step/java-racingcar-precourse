package racingcar.car.model.domain;

import racingcar.car.model.dto.CarDTO;

public class Car {
    private final Location location;
    private final Name name;

    public Car(String name) {
        this.location = new Location(0);
        this.name = new Name(name);
    }

    public CarDTO carToDTO() {
        return new CarDTO(this.name.getName(), this.location.getLocation());
    }

    public int getLocation() {
        return location.getLocation();
    }

    public String getName() {
        return name.getName();
    }

    public void move(int input) {
        location.move(input);
    }
}
