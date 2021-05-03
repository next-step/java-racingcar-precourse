package racingCar.domain;

public class Name {

  private static final Integer NAME_CONSTRAINT = 5;
  private final String name;

  public Name(String carName) {
    if (carName.length() > NAME_CONSTRAINT) {
      throw new ExceedCarNameException("자동차 이름의 길이가 5를 초과했습니다.");
    }
    this.name = carName;
  }
}
