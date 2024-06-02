package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceCars {

    private final List<Car> cars;

    public RaceCars() {
        cars = new ArrayList<>();
    }

    public void addCars(String[] carsName){
        for (String car : carsName) {
            cars.add(new Car(car));
        }
    }


    public List<Car> getCars() {
        return cars;
    }

}
