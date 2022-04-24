package racingcar;

import java.util.ArrayList;
import org.assertj.core.util.VisibleForTesting;

public class RacingCars {
    @VisibleForTesting
    ArrayList<RacingCar> cars = new ArrayList<>();

    public RacingCars(ArrayList<String> cars) {
        cars.forEach(car -> this.cars.add(new RacingCar(car)));
    }

    public void playRound() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber()));
    }
}
