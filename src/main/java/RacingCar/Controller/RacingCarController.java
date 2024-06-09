package RacingCar.Controller;

import RacingCar.Model.Race;
import RacingCar.View.InputView;
import java.util.List;

public class RacingCarController {

  public static void startGame() {
    List<String> carNames = InputView.getCarNames();
    int attempts = InputView.getNumberOfAttempts();

    Race race = new Race(carNames);

    for (int i = 0; i < attempts; i++) {
      race.moveCars();
    }


  }
}
