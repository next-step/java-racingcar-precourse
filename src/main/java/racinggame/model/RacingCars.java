package racinggame.model;

import racinggame.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<Car> racingCars;

    public RacingCars(List<String> racingCars) {
        if (!validateInput(racingCars)) {
            throw new ValidationException();
        }
        this.racingCars = createCar(racingCars);
    }

    private List<Car> createCar(List<String> racingCars) {
        List<Car> carList = new ArrayList<>();
        for (String name : racingCars) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private boolean validateInput(List<String> racingCars) {
        return racingCars.size() > 0;
    }

}
