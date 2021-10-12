package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class RacingResult {

  private final Map<Integer, Car> cars;

  public RacingResult(Map<Integer, Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return new ArrayList<>(cars.values());
  }

}
