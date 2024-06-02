package controller;

public class ValidateInput {

  public boolean carNamesValidate(String[] carNames) {
    boolean carNameInputState = true;
    for (String carName : carNames) {
      carNameInputState = carNameValidate(carName);
      if (!carNameInputState) {
        break;
      }
    }
    return carNameInputState;
  }

  public static boolean carNameValidate(String carName) {
    try {
      if (carName.length() > 5) {
        throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  public boolean playCountValidate(String playCount) {
    try {
      if (!playCount.matches("[1-9]\\d*")) {
        throw new IllegalArgumentException("[ERROR] 시도할 회수는 양의 정수만 가능합니다.");
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }
}
