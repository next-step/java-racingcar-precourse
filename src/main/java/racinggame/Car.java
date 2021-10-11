package racinggame;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class Car {

  private final String carName;

  public Car(String carName) {
    this.carName = carName;
  }

  public CarMoveStatus racing(int num) {
    if (num <= 3) {
      return CarMoveStatus.STOP;
    }
    return CarMoveStatus.FORWARD;
  }
}
