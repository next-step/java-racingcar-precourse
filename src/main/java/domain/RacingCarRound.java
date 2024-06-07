package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarRound {

    private final Integer round;
    public final List<RacingCar> racingCars;

    private RacingCarRound(Integer round, List<RacingCar> racingCars) {
        this.round = round;
        this.racingCars = racingCars;
    }

    public static RacingCarRound create(Integer round, List<RacingCar> racingCars) {
        return new RacingCarRound(round, racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public RacingCarRound copy() {
        List<RacingCar> copiedCars = racingCars.stream()
            .map(RacingCar::copy)
            .collect(Collectors.toList());
        return new RacingCarRound(this.round, copiedCars);
    }
}
