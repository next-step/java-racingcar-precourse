package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingMatch {
    public static final RacingMatch START = new RacingMatch();

    private RacingCars racingCars;
    private Lap lap;

    private RacingMatch() {
    }

    public RacingMatch(RacingCars racingCars, Lap lap) {
        this.racingCars = racingCars;
        this.lap = lap;

        race();
    }

    private void race() {
        for (int i = 0; i < lap.getLap(); i++) {
            raceOneLap();
        }
    }

    public CarNames getWinnerCarNames() {
        List<CarName> winnerNames = new ArrayList<>();
        Lap farthestLap = racingCars.getFarthestLap();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            addWinnerNameToList(winnerNames, racingCar, farthestLap);
        }
        return new CarNames(winnerNames);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public Lap getLap() {
        return lap;
    }

    private void raceOneLap() {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            racingCar.raceOneLap();
        }
    }

    private void addWinnerNameToList(List<CarName> carNameList,
        RacingCar racingCar, Lap farthestLap) {
        if (farthestLap.compareTo(racingCar.getCurrentLap()) == 0) {
            carNameList.add(racingCar.getCarName());
        }
    }
}
