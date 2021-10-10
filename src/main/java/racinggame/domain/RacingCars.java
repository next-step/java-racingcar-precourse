package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getMaxMovesCount() {
        List<Integer> movesCounts = new ArrayList<>();
        racingCars.forEach(racingCar -> movesCounts.add(racingCar.getMovesCount()));

        return Collections.max(movesCounts);
    }
}
