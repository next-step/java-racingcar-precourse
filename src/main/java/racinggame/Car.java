package racinggame;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class Car {

  private final String carName;

  private int countForward = 0;

  public Car(String carName) {
    this.carName = carName;
  }

  public CarMoveStatus racing(int num) {
    if (num <= 3) {
      return CarMoveStatus.STOP;
    }
    this.countForward ++;
    return CarMoveStatus.FORWARD;
  }

  public int getCountForward() {
    return countForward;
  }
}
