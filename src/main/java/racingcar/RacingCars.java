package racingcar;

import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars){
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void runEachRacingcCarRace() {
        for(RacingCar racingCar : this.racingCars){
            racingCar.race();
        }
    }
}
