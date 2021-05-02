package racingcar;

import utils.RandomValueGenerator;

import java.util.LinkedHashSet;
import java.util.Set;

public class RacingCars {
    private final Set<RacingCar> racingCars;

    public RacingCars(Set<Name> names) {
        this.racingCars = new LinkedHashSet<>();
        for (Name name : names)
            racingCars.add(new RacingCar(name));
    }

    public void moveForward() {
        racingCars.forEach(racingCar -> racingCar.moveForward(RandomValueGenerator.generate()));
    }

    public Set<RacingCar> getRacingCars() {
        return racingCars;
    }
}
