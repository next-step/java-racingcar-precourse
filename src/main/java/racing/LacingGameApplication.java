package racing;

import racing.domain.Cars;
import racing.domain.Round;
import racing.rule.OperationMoveRule;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LacingGameApplication {

  public static void main(String[] args) {
    String playerNames = InputView.getPlayerNames();
    Cars cars = Cars.generateFromInputString(playerNames);
    int countOfTotal = InputView.getTryNumber();

    List<Round> rounds = new ArrayList<>(countOfTotal);
    while (countOfTotal > 0) {
      cars = cars.race(new OperationMoveRule());
      rounds.add(Round.record(cars, countOfTotal--));
    }

    ResultView.printExecute(rounds);
  }
}
