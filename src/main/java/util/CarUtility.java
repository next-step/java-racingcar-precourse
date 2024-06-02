package util;

import java.util.Arrays;

public class CarUtility {

  public String[] carNamesSplit(String carNames) {
    return Arrays.stream(carNames.split(",")).map(String::strip)
        .toArray(String[]::new);
  }

  public boolean carMovement() {
    int randomNum = (int) (Math.random() * 10);
    return randomNum >= 4;
  }
}
