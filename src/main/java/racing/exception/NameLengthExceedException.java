package racing.exception;

public class NameLengthExceedException extends IllegalArgumentException {
  private static final String EXCEPTION_MESSAGE_FORMAT = "자동차 이름은 %d자 이하만 가능하다.";

  public NameLengthExceedException(final int maxOfLength) {
    super(String.format(EXCEPTION_MESSAGE_FORMAT, maxOfLength));
  }
}
