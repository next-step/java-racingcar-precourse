package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

  public void printDistance(Car car) {
    System.out.println(car.getName() + " :" + "-".repeat(car.getDistance()));
  }

  public void printHead() {
    System.out.println("실행 결과");
  }

  public void printWinners(List<Car> winners) {
    String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
    System.out.println("최종 우승자 : " + winnerNames);
  }
}
