package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
  private final List<Car> cars;

  public RacingGame(String[] carNames) {
    cars = new ArrayList<>();
    for (String name : carNames) {
      cars.add(new Car(name));
    }
  }

  public List<Car> getCars() {
    return cars;
  }

  public void race() {
    for (Car car : cars) {
      int randomValue = (int) (Math.random() * 10);
      if (car.canMove(randomValue)) {
        car.move();
      }
    }
  }

  public List<String> getWinners() {
    int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car.getName());
      }
    }
    return winners;
  }
}

