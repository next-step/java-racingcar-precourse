package racingcar.view;

import java.util.List;
import racingcar.code.Message;

public class OutputView {

  public static void roundResult(String roundResult) {
    System.out.println(Message.ROUND_END_MESSAGE.getMsg());
    System.out.println(roundResult);
  }

  public static void winnerResult(String winner) {
    System.out.println(Message.WINNER_MESSAGE.getWinner(winner));
  }
}