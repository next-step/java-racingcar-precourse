package racingcar.car.view;

import java.util.List;
import racingcar.car.model.Car;
import racingcar.car.model.Cars;
import racingcar.printer.Printer;

public class RacingView {
  private final Printer printer;

  public RacingView(final Printer printer) {
    this.printer = printer;
  }

  public void printRacingProcess(Cars cars) {
    for (Car car : cars.getCars()) {
      printer.print(String.format("%s : %s\n", car.getName(), car.getHistory()));
    }
    printer.print("\n");
  }
}
