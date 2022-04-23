package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<Car> racingCars = new ArrayList<>();

    public void addRacingCar(String carName) {
        this.racingCars.add(new Car(carName));
    }
}