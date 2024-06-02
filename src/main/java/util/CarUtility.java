package util;

import java.util.Arrays;

public class CarUtility {

  public String[] carNamesSplit(String carNames) {
    return Arrays.stream(carNames.split(",")).map(String::strip)
        .toArray(String[]::new);
  }

  public int carMovement() {
    int randomNum = (int) (Math.random() * 10);
    if (randomNum >= 4) {
      return 1;
    }
    return 0;
  }
}
