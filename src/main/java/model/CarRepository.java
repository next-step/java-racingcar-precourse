package model;

import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars=new ArrayList<>();
    public void addCar(Car car){
        cars.add(car);
    }
    public List<Car> getCars(){
        return cars;
    }
}
