package domain;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private final List<Car> cars;

    public Track() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String carName){
        cars.add(new Car(carName));
    }
}
