package racinggame;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class ValidationUtils {

  private static final int MAX_LENGTH = 5;

  public static boolean carNameLessThan5words(String carName) {
    return carName.length() <= MAX_LENGTH;
  }

  public static boolean isNum(String num) {
    try{
      Integer.parseInt(num);
      return true;
    } catch (NumberFormatException e) {
     return false;
    }
  }
}
