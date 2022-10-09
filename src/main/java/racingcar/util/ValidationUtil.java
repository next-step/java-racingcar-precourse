package racingcar.util;

import java.util.List;
import org.junit.platform.commons.util.StringUtils;
import racingcar.code.Message;

public class ValidationUtil {

  private static final Integer MAX_LENGTH = 5;
  public static void isMaxLength(String input) throws IllegalArgumentException {
    if (input.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(Message.ERROR_NAME_LENGTH.getMsg());
    }
  }

  public static void isNull(String input) throws IllegalArgumentException {
    if(StringUtils.isBlank(input)) {
      throw new IllegalArgumentException(Message.ERROR_INPUT_BLANK.getMsg());
    }
  }

  public static List<String> isElementLength(List<String> parseList) {
    for (String element : parseList) {
      isMaxLength(element);
    }
    return parseList;
  }
}
