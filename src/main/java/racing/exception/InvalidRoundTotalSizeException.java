package racing.exception;

public class InvalidRoundTotalSizeException extends IllegalArgumentException {
  private static final String EXCEPTION_MESSAGE_FORMAT = "최소한 %d 이상의 라운드가 필요합니다.";

  public InvalidRoundTotalSizeException(int countOfMin) {
    super(String.format(EXCEPTION_MESSAGE_FORMAT, countOfMin));
  }
}
