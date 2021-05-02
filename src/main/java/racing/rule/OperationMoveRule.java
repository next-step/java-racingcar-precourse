package racing.rule;

import java.util.Random;

public class OperationMoveRule implements MoveRule {
  public static final int MAX_OF_RANDOM_NUMBER = 10;
  public static final int MIN_OF_MOVE_NUMBER = 4;

  @Override
  public boolean isForward() {
    return randomNumber() >= MIN_OF_MOVE_NUMBER;
  }

  private int randomNumber() {
    return new Random().nextInt(MAX_OF_RANDOM_NUMBER);
  }
}
