package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Cars {

  private static Random RANDOM = new Random();
  private static final int BOUND = 10;
  private static final int MOVE_CONDITION = 4;

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public Cars(Car... cars) {
    this(Arrays.asList(cars));
  }

  public Cars moveByStrategy(MoveStrategy strategy) {
    List<Car> moveCars = new ArrayList<>();
    for (Car car : cars) {
      moveCars. add(car.move(strategy));
    }
    return new Cars(moveCars);
  }

  public Cars moveByStrategy() {
    return moveByStrategy(() -> RANDOM.nextInt(BOUND) >= MOVE_CONDITION);
  }

  public Map<String, Integer> result() {
    Map<String, Integer> position = new HashMap<>();
    for (Car car : cars) {
      position.put(car.name(), car.position());
    }
    return position;
  }

  public List<String> getNames() {
    List<String> names = new ArrayList<>();
    for (Car car : cars) {
      names.add(car.name());
    }
    return names;
  }
}
