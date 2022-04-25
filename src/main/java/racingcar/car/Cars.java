package racingcar.car;

import racingcar.game.Printer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Cars {

    private final Set<Car> cars;

    private Cars() {
        this.cars = initCar();
    }

    public static Cars init() {
        try {
            Printer.initCars();
            return new Cars();
        } catch (IllegalArgumentException e) {
            return init();
        }
    }

    public Set<Car> list() {
        return this.cars;
    }

    private Set<Car> initCar() throws IllegalArgumentException {
        Set<Car> cars = new LinkedHashSet<>();

        for (CarName name : CarNames.fromConsole().names()) {
            cars.add(Car.of(name));
        }

        return cars;
    }

}
