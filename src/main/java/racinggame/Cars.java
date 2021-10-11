package racinggame;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

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

  public List<Car> racing(List<Integer> moveNum) {
    for (int i = 0; i < moveNum.size(); i++) {
      cars.get(i).racing(moveNum.get(i));
    }
    return cars;
  }

  public RacingResult racingTime(int racingTime) {
    for(int i=0; i<racingTime; i++) {
      cars.get(i).racing(Randoms.pickNumberInRange(0, 9));
    }
    return new RacingResult(cars);
  }
}
