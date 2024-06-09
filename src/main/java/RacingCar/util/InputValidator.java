package RacingCar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

  public static List<String> checkCarValid(String input) {
    List<String> carNames = List.of(input.split(","));
    Set<String> uniqueNames = new HashSet<>();
    for (String name : carNames) {
      if (name.length() > 5 || name.isBlank()) {
        throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.");
      }
      if (!uniqueNames.add(name)) {
        throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 있습니다: " + name);
      }
    }
    return carNames;
  }

  public static int checkAttemptValid(String input) {
    try {
      int attempts = Integer.parseInt(input);
      if (attempts <= 0) {
        throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
      }
      return attempts;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 1 이상의 자연수를 입력해주세요.");
    }
  }

}
