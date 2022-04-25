package racingcar.car.view;

import racingcar.car.model.Car;
import racingcar.car.model.Cars;
import racingcar.car.model.Result;
import racingcar.printer.Printer;

public class ResultView {
  private final Printer printer;

  public ResultView(final Printer printer) {
    this.printer = printer;
  }

  public void printResult(Result result) {
    printer.print(String.format("최종 우승자: %s", String.join(",", result.getWinnerNames())));
  }
}
