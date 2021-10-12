package racinggame.model;

import racinggame.model.Car.Car;

import java.util.List;
import java.util.StringJoiner;

public class Winner {
  public static final String WINNER_MSG = "최종 우승자는 %s 입니다.";
  List<Car> winners;

  public Winner(Cars cars) {
    this.winners = getWinners(cars);
  }

  public List<Car> getWinners(Cars cars) {
    return cars.getCarsOnPosition(cars.getLastPosition());
  }

  public String print() {
    StringJoiner sj = new StringJoiner(",");
    for (Car car : winners) {
      sj.add(car.getName().toString());
    }
    return String.format(WINNER_MSG, sj);
  }
}
