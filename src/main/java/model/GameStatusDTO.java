package model;

import java.util.ArrayList;
import java.util.List;

public class GameStatusDTO {

  private List<CarDTO> cars;

  public GameStatusDTO() {
    cars = new ArrayList<>();
  }

  public List<CarDTO> getCars() {
    return cars;
  }

  public void setCars(List<CarDTO> cars) {
    this.cars = cars;
  }

  public void addCar(String carName) {
    CarDTO car = new CarDTO(carName);
    cars.add(car);
  }
}
