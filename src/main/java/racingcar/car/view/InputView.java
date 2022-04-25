package racingcar.car.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.model.Cars;
import racingcar.car.model.Racing;
import racingcar.printer.Printer;

public class InputView {
  private final Printer printer;

  private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
  public static final String NAME_DELIMITER = ",";
  private static final String TRY_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?\n";

  public InputView(final Printer printer) {
    this.printer = printer;
  }


  public int readAttemptCount() {
    printer.print(TRY_NUMBER_MESSAGE);
    String input = Console.readLine();
    return Integer.parseInt(input);
  }


  public Cars readCars() {
    printer.print(CAR_NAME_MESSAGE);
    try {
      String input = Console.readLine();
      return new Cars(input.split(NAME_DELIMITER));
    } catch (IllegalArgumentException e) {
      printer.print(e.getMessage());
    }

    return null;
  }
}
