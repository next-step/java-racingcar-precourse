package racingcar.model;

import racingcar.utils.Message;

public class Round {
  public static final int MinNumber = 0;
  private final int round;

  public int getRound() {
    return round;
  }

  public Round(String s) {
    try {
      round = Integer.parseInt(s);
    }
    catch (Exception e) {
      throw new IllegalArgumentException(Message.NON_NUMERIC_GAME_COUNT_ERROR);
    }
    if (MinNumber >= round) {
      throw new IllegalArgumentException(Message.ZERO_GAME_COUNT_ERROR);
    }
  }
}
