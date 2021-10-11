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
    return lessThan5words(carName);
  }

  private static boolean lessThan5words(String carName) {
    if(carName.length() > MAX_LENGTH) {
      return false;
    }
    return true;
  }
}
