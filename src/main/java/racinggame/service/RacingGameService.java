package racinggame.service;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.Car;

public class RacingGameService {
    private List<Car> cars = new ArrayList<>();

    public void initCar(String carNames){
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName.trim()));
        }
    }

    public void race(int numOfAttempts){
        for (int i = 0; i < numOfAttempts; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

}
