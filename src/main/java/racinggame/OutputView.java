package racinggame;

import java.util.List;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/12
 * @description :
 */
public class OutputView {

  private static final String ERROR = "[ERROR]";
  private static final String FORWARD = "-";

  public static void errorMsg(String errMsgMaxLength) {
    System.out.println(ERROR + errMsgMaxLength);
  }

  public static void racing(RacingResult result) {
    List<Car> cars = result.getCars();

  }
}
