package racingcar.car.exception;

public class CarNameLengthException extends IllegalArgumentException {
  private static final String MESSAGE = "[ERROR] 이름은 5글자가 최대입니다.";

  public CarNameLengthException() {
    super(MESSAGE);
  }
}
