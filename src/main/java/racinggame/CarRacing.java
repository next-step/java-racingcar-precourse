package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    for (int i = 0; i < racingTime; i++) {
      RacingResult result = cars.racing(moveNums.getCarMoveNums());
      OutputView.racing(result);
      countRacingTime++;
    }
  }

  public boolean isFinish() {
    if (racingTime == countRacingTime) {
      return true;
    }
    return false;
  }

  public List<Car> winner() {
    List<Car> winner = new ArrayList<>();
    int maxCountForwardNum = getMaxCountForward(getCountForwardValues());
    for (Car car : cars.getCars().values()) {
      maxCountForwardCars(winner, car, maxCountForwardNum);
    }
    return winner;
  }

  private void maxCountForwardCars(List<Car> winner, Car car, int maxCountForwardNum) {
    if (car.getCountForward() == maxCountForwardNum) {
      winner.add(car);
    }
  }

  private int getMaxCountForward(Set<Integer> countForwardValues) {
    List<Integer> sortCountForward = new ArrayList<>(countForwardValues);
    Collections.reverse(sortCountForward);
    return sortCountForward.get(0);
  }

  private Set<Integer> getCountForwardValues() {
    Set<Integer> countForwardValues = new HashSet<>();
    for (Car car : cars.getCars().values()) {
      countForwardValues.add(car.getCountForward());
    }
    return countForwardValues;
  }
}
