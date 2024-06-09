package domain;

import java.util.ArrayList;

public class CarRepository {
    ArrayList<Car> cars = new ArrayList<>();

    void save(Car car){
        cars.add(car);
    }

    public ArrayList<Car> findAll(){
        return cars;
    }
}
