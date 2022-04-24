package racingcar.model.Car;

import racingcar.utils.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class Cars {
  private final List<Car> cars = new ArrayList<>();

  private Position lastPosition = new Position();

  public Cars(String input) {
    inputValidate(input);
    buildCars(input);
  }

  private void inputValidate(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException(Message.ASK_CAR_NAMES);
    }
  }

  private void buildCars(String input) {
    String[] splitCar = input.split(",");
    for (int i = 0; i < splitCar.length; i++) {
      cars.add(new Car(splitCar[i]));
    }
  }

  public String print() {
    StringJoiner sj = new StringJoiner("\n");
    for (int i = 0; i < cars.size(); i++) {
      sj.add(cars.get(i).toString());
    }
    return sj.toString();
  }

  public void drive(Predicate<Car> moveStrategy) {
    for (Car car : cars) {
      if (moveStrategy.test(car)) {
        car.move();
        lastMoveUpdate(car.getPosition());
      }
    }
  }

  private void lastMoveUpdate(Position position) {
    lastPosition = lastPosition.getValue() > position.getValue() ? lastPosition : position;
  }

  public Position getLastPosition() {
    return lastPosition;
  }

  public List<Car> getCarsOnPosition(Position pos) {
    List<Car> carsOnPosition = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition().equals(pos)) {
        carsOnPosition.add(car);
      }
    }
    return carsOnPosition;
  }

}
