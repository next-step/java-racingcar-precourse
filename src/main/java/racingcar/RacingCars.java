package racingcar;

import java.util.HashSet;
import java.util.Set;

public class RacingCars {
    private final Set<RacingCar> racingCars;

    public RacingCars(Set<Name> names) {
        this.racingCars = new HashSet<>();
        for (Name name : names) {
            racingCars.add(new RacingCar(name));
        }
    }
}
