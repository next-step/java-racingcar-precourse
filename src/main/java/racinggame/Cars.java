package racinggame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class Cars {

  private final Map<Integer, Car> cars;

  public Map<Integer, Car> getCars() {
    return cars;
  }

  public Cars(List<Car> cars) {
    this.cars = mapCar(cars);
  }

  private static Map<Integer, Car> mapCar(List<Car> cars) {
    Map<Integer, Car> mapCar = new HashMap<>();
    for(int i=0; i<cars.size(); i++) {
      mapCar.put(i, cars.get(i));
    }
    return mapCar;
  }

  public RacingResult racing(List<Integer> moveNums) {
    for (int i = 0; i < moveNums.size(); i++) {
      cars.get(i).move(moveNums.get(i));
    }

    return new RacingResult(cars);
  }
}
