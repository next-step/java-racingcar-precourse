package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<RacingCar> racingCars = new ArrayList<>();

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public void addRacingCar(RacingCar racingCar) {
        this.racingCars.add(racingCar);
    }
}