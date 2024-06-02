package repository;

import domain.Car;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
  private int id = 0;
  private final Map<Integer,Car> cars = new HashMap<>();
  public void save(Car car){
    cars.put(id,car);
    id += 1;
  }
  public List<Car> findAll() {
    return new ArrayList<>(cars.values());
  }
}
