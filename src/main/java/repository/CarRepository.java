package repository;

import domain.Car;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
    private static final Map<String, Car> carList = new LinkedHashMap<>();

    public List<Car> findAllCar(){
        return new ArrayList<>(carList.values());
    }

    public void saveCar(Car car){
        carList.put(car.getName(), car);
    }

    public void findByName(){
    }
}
