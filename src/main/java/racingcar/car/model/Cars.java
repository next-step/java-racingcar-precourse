package racingcar.car.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(String[] inputs) {
    this.cars = buildCarNames(inputs);
  }

  private List<Car> buildCarNames(String[] inputs) {
    List<Car> names = new ArrayList<>();

    for (String input : inputs) {
      names.add(new Car(input));
    }

    return names;
  }

  public List<Car> getCars() {
    return cars;
  }

  public Car get(int index) {
    return cars.get(index);
  }

  public int size() {
    return cars.size();
  }

  public int getHighestScore() {
    Collections.sort(cars);
    return cars.get(0).getHistorySize();
  }
}
