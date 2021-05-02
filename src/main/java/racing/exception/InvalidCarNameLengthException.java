package racing.exception;

public class InvalidCarNameLengthException extends IllegalArgumentException {
  private static final String EXCEPTION_MESSAGE_FORMAT = "자동차 이름은 %d자 이하만 가능하다.";

  public InvalidCarNameLengthException(final int maxOfLength) {
    super(String.format(EXCEPTION_MESSAGE_FORMAT, maxOfLength));
  }
}
