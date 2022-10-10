package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceWinners {
    private int raceWinnderPosition;
    private List<RacingCar> racingCars = new ArrayList<>();

    public int getRaceWinnderPosition() {
        return raceWinnderPosition;
    }

    public void setRaceWinnderPosition(int raceWinnderPosition) {
        this.raceWinnderPosition = raceWinnderPosition;
    }

    public List<RacingCar> getRaceWinners() {
        return this.racingCars;
    }

    public void addRaceWinner(RacingCar racingCar) {
        this.racingCars.add(racingCar);
    }
}
