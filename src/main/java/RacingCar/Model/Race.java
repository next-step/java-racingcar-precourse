package RacingCar.Model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {

  private final List<Car> cars;
  private final Random random = new Random();

  public Race(List<String> carNames) {
    cars = carNames.stream().map(Car::new).collect(Collectors.toList());
  }

  public void moveCars() {
    cars.forEach(car -> car.move(random.nextInt(10)));
  }

  public List<Car> getWinner() {
    int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

    return cars.stream().filter(car -> car.getPosition() == maxPosition)
        .collect(Collectors.toList());
  }

  public List<Car> getCars() {
    return cars;
  }

}
