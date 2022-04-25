package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Circuit {

    ArrayList<RacingCar> racingCars;
    LapCount lapCount;

    public ArrayList<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public LapCount getLapCount() {
        return this.lapCount;
    }

    public Circuit() {
        this.racingCars = new ArrayList<>();
    }

    public void makeRacingCars(ArrayList<String> nameList) throws IllegalArgumentException {
        for (String name : nameList) {
            this.racingCars.add(new RacingCar(name));
        }
    }

    public void insertLapCount(int lapCount) throws IllegalArgumentException {
        this.lapCount = new LapCount(lapCount);
    }

    public ArrayList<RacingCar> runLap() {
        for (RacingCar racingCar : this.getRacingCars()) {
            racingCar.race(Randoms.pickNumberInRange(1, 9));
        }
        return this.racingCars;
    }

    public ArrayList<String> getWinners() {
        int maxRaceProgress = this.getMaxRaceProgress(this.racingCars);
        ArrayList<String> winners = new ArrayList<String>();
        for (RacingCar racingCar : this.racingCars) {
            winners.add(this.getWinnerRacingCarName(maxRaceProgress, racingCar));
        }
        winners.removeIf(Objects::isNull);
        return winners;
    }

    private String getWinnerRacingCarName(int maxRaceProgress, RacingCar racingCar) {
        if (racingCar.getRaceProgress() == maxRaceProgress) return racingCar.getName();
        return null;
    }

    private int getMaxRaceProgress(ArrayList<RacingCar> racingCars) {
        return Collections.max(racingCars).getRaceProgress();
    }

}
