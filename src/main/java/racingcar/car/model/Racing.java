package racingcar.car.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

  public static final int MOVE_CONDITION_START = 0;
  public static final int MOVE_CONDITION_END = 9;

  private final Cars cars;

  public Racing(Cars cars) {
    this.cars = cars;
  }

  public void play() {
    for (Car car : cars.getCars()) {
      int randomNumber = Randoms.pickNumberInRange(MOVE_CONDITION_START, MOVE_CONDITION_END);
      car.runOrStopByNumber(randomNumber);
    }
  }
}
