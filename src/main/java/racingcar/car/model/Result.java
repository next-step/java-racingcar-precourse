package racingcar.car.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
  private final List<String> winnerNames;

  public Result(Cars cars) {
    this.winnerNames = new ArrayList<>();
    calculateWinner(cars);
  }

  public List<String> getWinnerNames() {
    return winnerNames;
  }

  private void calculateWinner(Cars cars) {
    for (int i = 0; i < cars.size(); i++) {
      addIfTied(cars.getHighestScore(), cars.get(i));
    }
  }

  private void addIfTied(int highestScore, Car car) {
    if (car.getHistorySize() == highestScore) {
      winnerNames.add(car.getName());
    }
  }
}
