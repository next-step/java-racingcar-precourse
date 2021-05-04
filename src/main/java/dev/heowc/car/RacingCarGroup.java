package dev.heowc.car;

import dev.heowc.condition.Condition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public final class RacingCarGroup {

    private final List<RacingCar> racingCars;

    public static RacingCarGroup create(String carNames, Condition condition) {
        final String[] racingCarNames = carNames.split(",");
        final List<RacingCar> cars = new ArrayList<>(racingCarNames.length);
        for (String racingCarName : racingCarNames) {
            final RacingCar car = RacingCar.from(racingCarName, condition);
            cars.add(car);
        }
        return new RacingCarGroup(cars);
    }

    private RacingCarGroup(List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public void forEach(Consumer<RacingCar> consumer) {
        racingCars.forEach(consumer);
    }

    List<RacingCar> cars() {
        return new ArrayList<>(racingCars);
    }
}
