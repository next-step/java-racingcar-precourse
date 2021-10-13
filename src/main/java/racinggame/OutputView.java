package racinggame;

import java.util.ArrayList;
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
  private static final String VERTICAL_DOT = ":";
  private static final String WINNER_MSG = "최종 우승자는 %s 입니다.";

  public static void errorMsg(String errMsgMaxLength) {
    System.out.println(ERROR + errMsgMaxLength);
  }

  public static void racing(RacingResult result) {
    mapDrawingForward(result.getCars());
  }

  private static void mapDrawingForward(List<Car> cars) {
    System.out.println();
    for (Car car : cars) {
      System.out.println(
          new StringBuilder()
              .append(car.getCarName())
              .append(" ")
              .append(VERTICAL_DOT)
              .append(" ")
              .append(drawingForward(car.getCountForward())));
    }
  }

  public static void racingWinner(List<Car> winner) {
    List<String> winnerCarNames = getWinnerCarNames(winner);
    String carNames = getSplitCarNames(winnerCarNames);
    System.out.println(String.format(WINNER_MSG, carNames));
  }

  private static String drawingForward(int countForward) {
    String forward = "";
    for (int i = 0; i < countForward; i++) {
      forward += FORWARD;
    }
    return forward;
  }

  private static List<String> getWinnerCarNames(List<Car> winner) {
    List<String> winnerCarNames = new ArrayList<>();
    for (Car car : winner) {
      winnerCarNames.add(car.getCarName());
    }
    return winnerCarNames;
  }

  private static String getSplitCarNames(List<String> winnerCarNames) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String carName : winnerCarNames) {
      splitCarName(carName, stringBuilder);
    }
    return stringBuilder.toString();
  }

  private static void splitCarName(String carName, StringBuilder stringBuilder) {
    if (stringBuilder.length() > 0) {
      stringBuilder.append(",");
    }
    stringBuilder.append(carName);
  }
}
