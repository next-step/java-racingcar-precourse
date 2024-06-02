package models;

import java.util.ArrayList;
import java.util.List;

import utils.RandomGenerator;

public class Race {
    private final List<Car> cars = new ArrayList<>();

    public Race(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void start(int moves) {
        for (int i = 0; i < moves; i++) {
            for (Car car : cars) {
                car.move(RandomGenerator.generateRandomNumber());
            }
        }
    }

    
}
