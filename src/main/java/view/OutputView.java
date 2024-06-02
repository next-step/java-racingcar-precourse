package view;

import controller.GamePlay;
import java.util.List;
import java.util.StringJoiner;
import model.CarDTO;
import model.GameStatusDTO;

public class OutputView {

  public OutputView() {
  }

  public void initPrintCarsStatus() {
    System.out.println("실행 결과");
  }

  public void printCarsStatus() {
    for (CarDTO car : GameStatusDTO.cars) {
      System.out.println(car);
    }
    System.out.println();
  }

  public void printWinners() {
    StringJoiner joiner = new StringJoiner(", ");
    List<String> winners = GameStatusDTO.winners;
    System.out.print("최종 우승자 : ");
    for (String winner : winners) {
      joiner.add(winner);
    }
    System.out.print(joiner);
  }
}
