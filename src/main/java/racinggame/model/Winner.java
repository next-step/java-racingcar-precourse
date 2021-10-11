package racinggame.model;

import racinggame.model.Car.Car;
import racinggame.model.Cars.Cars;

import java.util.List;
import java.util.StringJoiner;

public class Winner {
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
    return String.format("최종 우승자는 %s 입니다.", sj);
  }
}
