package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import static racinggame.constants.RaceGameConstants.RANDOM_NUMBER_MAX;
import static racinggame.constants.RaceGameConstants.RANDOM_NUMBER_MIN;

public class RaceGame {

    private final List<RaceCar> raceCars = new ArrayList<>();

    public RaceGame(List<String> raceCarNames) {
        setRaceCars(raceCarNames);
    }

    public List<RaceCar> run() {
        raceCars.forEach(car -> {
            runRace(car);
        });
        return raceCars;
    }

    private void setRaceCars(List<String> raceCarNames) {
        for (String car : raceCarNames) {
            addRaceCar(car);
        }
    }
    private void addRaceCar(String car) {
        raceCars.add(new RaceCar(car, 0));
    }

    private void runRace(RaceCar car) {
        if (RaceOperate.run(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX).equals(RaceOperate.MOVE)) {
            car.move();
        }
    }
}
