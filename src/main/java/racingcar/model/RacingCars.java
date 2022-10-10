package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars(CarNames carNames) {
        this.racingCars = toRacingCarList(carNames);
    }

    public Lap getFarthestLap() {
        int max = 0;
        for (RacingCar racingCar : racingCars) {
            Lap currentLap = racingCar.getCurrentLap();
            max = Math.max(currentLap.getLap(), max);
        }
        return new Lap(max);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    private List<RacingCar> toRacingCarList(CarNames carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (CarName carName : carNames.getNames()) {
            racingCars.add(new RacingCar(carName, RacingCarMoveStrategy.DEFAULT));
        }
        return racingCars;
    }
}
