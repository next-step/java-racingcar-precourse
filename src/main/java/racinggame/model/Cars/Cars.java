package racinggame.model.Cars;

import racinggame.model.Car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class Cars {
  public static final String INPUT_ERROR_MSG = "자동차 이름을 입력하세요";
  private final List<Car> cars = new ArrayList<>();

  public Cars(String input) {
    inputValidate(input);
    buildCars(input);
  }

  private void inputValidate(String input) {
    if(input == null || input.isEmpty()){
      throw new IllegalArgumentException(INPUT_ERROR_MSG);
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
    for (int i = 0; i < cars.size(); i++) {
      Car car = cars.get(i);
      if(moveStrategy.test(car)){
        car.move();
      }
    }
  }
}
