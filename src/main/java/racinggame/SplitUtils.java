package racinggame;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class SplitUtils {

  private static final String COMMA = ",";

  public static String[] split(String carNames) {
    return carNames.split(COMMA);
  }
}
