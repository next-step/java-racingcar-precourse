package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public void addRacingCar(RacingCar racingCar) {
        this.racingCars.add(racingCar);
    }

    public int getSize() {
        return this.racingCars.size();
    }
}
