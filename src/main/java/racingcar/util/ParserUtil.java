package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class ParserUtil {

  public static List<String> StringToList(String input) throws IllegalArgumentException {
    String[] carNames = input.split(",");
    return ValidationUtil.isElementLength(Arrays.asList(carNames));
  }


}
