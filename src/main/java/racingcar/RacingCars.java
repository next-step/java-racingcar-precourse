package racingcar;

import racingcar.support.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String carNames) {
        this.carNameSetting(carNames);
    }

    private void carNameSetting(String carNames) {
        for (String carName : carNames.split(",")) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public void start(RandomNumberGenerator generator) {
        List<Integer> randomNumbers = generator.generate(racingCars.size());

        for (int i = 0; i < randomNumbers.size(); i++) {
            racingCars.get(i).moveOnCondition(randomNumbers.get(i));
        }
    }

    @Override
    public String toString() {
        return "RacingCars{" +
                "racingCars=" + racingCars +
                '}';
    }
}
