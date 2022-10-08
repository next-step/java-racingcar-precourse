package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }

    public void add(String[] carNames) {
        for(String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public void add(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public RacingCar get(int index) {
        return racingCars.get(index);
    }

    public int size() {
        return racingCars.size();
    }

    @Override
    public String toString() {
        String str = racingCars.toString();
        return str.substring(1, str.length() - 1);
    }
}
