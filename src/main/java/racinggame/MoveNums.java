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

  private final List<Integer> carMoveNums;

  public MoveNums(Cars cars) {
    List<Integer> moveNum = new ArrayList<>();
    for(int i = 0; i<cars.getCars().size(); i++) {
      moveNum.add(Randoms.pickNumberInRange(0,9));
    }
    this.carMoveNums = moveNum;
  }

  public List<Integer> getCarMoveNums() {
    return carMoveNums;
  }
}
