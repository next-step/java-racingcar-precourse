package racing;

import racing.domain.Cars;
import racing.domain.Rounds;
import racing.view.InputView;
import racing.view.ResultView;

public class LacingGameApplication {

  public static void main(String[] args) {
    String playerNames = InputView.getPlayerNames();
    Cars cars = Cars.generateFromInputString(playerNames);
    int countOfTotal = InputView.getTryNumber();

    ResultView.printExecute(Rounds.generate(countOfTotal, cars));
  }
}
