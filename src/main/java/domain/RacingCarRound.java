package domain;

import java.util.List;

public class RacingCarRound {

    private final Integer round;
    private final List<RacingCar> racingCars;

    private RacingCarRound(Integer round, List<RacingCar> racingCars) {
        this.round = round;
        this.racingCars = racingCars;
    }

    public static RacingCarRound create(Integer round, List<RacingCar> racingCars) {
        return new RacingCarRound(round, racingCars);
    }

}
