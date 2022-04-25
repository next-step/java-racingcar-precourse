package racingcar.car.controller;

import racingcar.car.model.Cars;
import racingcar.car.model.Racing;
import racingcar.car.model.Result;
import racingcar.car.view.InputView;
import racingcar.car.view.RacingView;
import racingcar.car.view.ResultView;
import racingcar.printer.SystemPrinter;


public class GameManager {

  private final InputView inputView;
  private final ResultView resultView;
  private final RacingView racingView;

  public GameManager(final SystemPrinter printer) {
    this.inputView = new InputView(printer);
    this.resultView = new ResultView(printer);
    this.racingView = new RacingView(printer);
  }

  public void start() {
    final Cars cars = inputView.readCars();
    final int attemptCount = inputView.readAttemptCount();
    final Racing racing = new Racing(cars);

    play(cars, attemptCount, racing);

    resultView.printResult(new Result(cars));
  }

  private void play(Cars cars, int attemptCount, Racing racing) {
    for (int i = 0; i < attemptCount; i++) {
      racing.play();
      racingView.printRacingProcess(cars);
    }
  }
}
