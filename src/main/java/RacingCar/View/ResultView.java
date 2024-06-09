package RacingCar.View;

import RacingCar.Model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

  public static void printCarPostion(List<Car> carList) {
    for (Car car : carList) {
      System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }
    System.out.println();
  }
}
