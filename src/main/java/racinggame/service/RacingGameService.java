package racinggame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racinggame.domain.Car;

public class RacingGameService {
    private List<Car> cars = new ArrayList<>();

    public void initCar(String carNames){
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName.trim()));
        }
    }



}
