package model;

import java.util.ArrayList;
import java.util.List;

public class GameStatusDTO {

  private List<CarDTO> cars;
  private int playCount;

  public GameStatusDTO() {
    cars = new ArrayList<>();
  }

  public List<CarDTO> getCars() {
    return cars;
  }

  public void addCar(String carName) {
    CarDTO car = new CarDTO(carName);
    cars.add(car);
  }

  public int getPlayCount() {
    return playCount;
  }

  public void setPlayCount(int playCount) {
    this.playCount = playCount;
  }
}
