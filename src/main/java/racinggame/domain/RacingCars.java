package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(final List<String> names) {
        this.racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(new RacingCar(new Name(name)));
        }
    }

    public void race(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            moveRacingCars();
        }
    }

    private void moveRacingCars() {
        for (RacingCar car : racingCars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }
}
