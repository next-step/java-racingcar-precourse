package racinggame;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class ValidationUtils {

  private static final int MAX_LENGTH = 5;
  private static final String ERR_MSG_MAX_LENGTH = "5자리 이하로만 가능합니다.";
  private static final String ERR_MSG_IS_NOT_NUM = "레이싱 시도할 횟수를 입력해주시기 바랍니다.";

  public static boolean isCarNameLessThan5words(String carName) {
    if (carName.length() <= MAX_LENGTH) {
      return true;
    }
    OutputView.errorMsg(ERR_MSG_MAX_LENGTH);
    return false;
  }

  public static boolean isNum(String num) {
    try {
      Integer.parseInt(num);
      return true;
    } catch (NumberFormatException e) {
      OutputView.errorMsg(ERR_MSG_IS_NOT_NUM);
      return false;
    }
  }
}
