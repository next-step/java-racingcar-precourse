package racingcar.model;

import racingcar.model.Car.Car;
import racingcar.model.Car.Cars;
import racingcar.utils.Message;

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
    return Message.FINAL_WINNER + sj;
  }
}
