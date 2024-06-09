package RacingCar.Controller;

import RacingCar.Model.Race;
import RacingCar.View.InputView;
import RacingCar.View.ResultView;
import java.util.List;

public class RacingCarController {

  public static void startGame() {
    List<String> carNames = InputView.getCarNames();
    int attempts = InputView.getNumberOfAttempts();

    Race race = new Race(carNames);

    System.out.println("실행 결과\n");
    for (int i = 0; i < attempts; i++) {
      race.moveCars();
      ResultView.printCarPostion(race.getCars());
    }
  }
}
