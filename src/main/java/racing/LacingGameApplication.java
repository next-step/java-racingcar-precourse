package racing;

import racing.domain.Cars;
import racing.domain.Rounds;
import racing.domain.Winners;
import racing.view.InputView;
import racing.view.ResultView;

public class LacingGameApplication {

  public static void main(String[] args) {
    String playerNames = InputView.getPlayerNames();
    Cars cars = Cars.generateFromInputString(playerNames);
    int countOfTotal = InputView.getTryNumber();

    Rounds rounds = Rounds.generate(countOfTotal, cars);
    ResultView.printExecute(rounds);

    Winners winners = Winners.generate(rounds.finalRound());
    ResultView.printWinners(winners);
  }
}
