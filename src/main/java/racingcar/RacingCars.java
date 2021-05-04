package racingcar;

import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCar;

    public RacingCars(List<RacingCar> racingCar) {
        this.racingCar = racingCar;
    }

    public List<RacingCar> getRacingCar() {
        return racingCar;
    }
}
