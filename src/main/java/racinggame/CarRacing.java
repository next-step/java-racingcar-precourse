package racinggame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/13
 * @description :
 */
public class CarRacing {

  private final Cars cars;
  private final MoveNums moveNums;
  private final int racingTime;
  private int countRacingTime = 0;

  public CarRacing(Cars cars, MoveNums moveNums, int racingTime) {
    this.cars = cars;
    this.moveNums = moveNums;
    this.racingTime = racingTime;
  }

  public void start() {
    for(int i=0; i<racingTime; i++) {
      RacingResult result = cars.racing(moveNums.getCarMoveNums());
      OutputView.racing(result);
      countRacingTime++;
    }
  }

  public boolean isFinish() {
    if(racingTime == countRacingTime) {
      return true;
    }
    return false;
  }

  public List<Car> winner(){
    List<Car> winner = new ArrayList<>();
    int maxForwardCount = 0;
    for(Car car : cars.getCars().values()) {
      if(maxForwardCount <= car.getCountForward()) {
        maxForwardCount = car.getCountForward();
      }
    }

    for(Car car : cars.getCars().values()) {
      if(maxForwardCount == car.getCountForward()) {
        winner.add(car);
      }
    }

    return winner;
  }
}
