package racinggame;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/12
 * @description :
 */
public class MoveNums {

  private final int carSize;

  public MoveNums(Cars cars) {
    carSize = cars.getCars().size();
  }

  public List<Integer> getCarMoveNums() {
    List<Integer> moveNums = new ArrayList<>();
    for (int i = 0; i < carSize; i++) {
      moveNums.add(Randoms.pickNumberInRange(0, 9));
    }
    return moveNums;
  }
}
