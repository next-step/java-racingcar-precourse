package racing.exception;

public class PositionLessThenMinValueException extends IllegalArgumentException {
  private static final String EXCEPTION_MESSAGE_FORMAT = "최소 위치(%d)가 필요합니다.";

  public PositionLessThenMinValueException(int minOfPosition) {
    super(String.format(EXCEPTION_MESSAGE_FORMAT, minOfPosition));
  }
}
