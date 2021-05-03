package racing.view;

import racing.domain.Car;
import racing.domain.Round;

import java.util.List;

public final class ResultView {
  private static final String EXECUTE_RESULT = "\n실행 결과";
  private static final String ROUND_RESULT_OF_CAR_FORMAT = "%s : %s\n";
  private static final String POSITION_STRING = "-";

  private ResultView() {

  }

  public static void printExecute(List<Round> rounds) {
    System.out.println(EXECUTE_RESULT);

    for (Round round : rounds) {
      printResultOfRound(round);
      System.out.println();
    }
  }

  private static void printResultOfRound(Round round) {
    for (Car car : round.getCars().getValues()) {
      System.out.format(ROUND_RESULT_OF_CAR_FORMAT, car.getName(), toPositionString(car.getPosition()));
    }
  }

  private static String toPositionString(int position) {
    StringBuilder sb = new StringBuilder();
    while (position > 0) {
      sb.append(POSITION_STRING);
      position--;
    }
    return sb.toString();
  }
}
