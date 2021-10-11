package racinggame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<CarMoveStatus> racing(List<Integer> moveNumList) {
    List<CarMoveStatus> carMoveStatuses = new ArrayList<>();
    for (int i = 0; i < moveNumList.size(); i++) {
      carMoveStatuses.add(cars.get(i).racing(moveNumList.get(i)));
    }
    return carMoveStatuses;
  }
}
