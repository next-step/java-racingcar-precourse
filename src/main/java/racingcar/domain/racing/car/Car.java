package racingcar.domain.racing.car;

import racingcar.domain.racing.car.accelerator.Accelerator;

public class Car {
    private final Name name;
    private final Location location;

    private Car(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    private Car(String name, int location) {
        this.name = Name.from(name);
        this.location = Location.from(location);
    }

    public static Car of(String name, int location) {
        return new Car(name, location);
    }

    public Car accelerate(Accelerator accelerator) {
        return new Car(name, accelerator.moveCar(location));
    }

    public int getLocation() {
        return location.get();
    }

    public String getName() { return name.get(); }
}
