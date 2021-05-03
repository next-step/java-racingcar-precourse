package racing.view;

import racing.domain.Car;
import racing.domain.Round;
import racing.domain.Rounds;
import racing.domain.Winners;

public final class ResultView {
  private static final String EXECUTE_RESULT = "\n실행 결과";
  private static final String ROUND_RESULT_OF_CAR_FORMAT = "%s : %s\n";
  private static final String POSITION_STRING = "-";
  private static final String FINAL_ROUND_OF_WINNERS_FORMAT = "%s가 최종 우승했습니다.";
  private static final String SEPARATOR_OF_WINNER_NAME = ", ";

  private ResultView() {

  }

  public static void printExecute(Rounds rounds) {
    System.out.println(EXECUTE_RESULT);

    for (Round round : rounds.getValues()) {
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

  public static void printWinners(Winners winners) {
    System.out.format(FINAL_ROUND_OF_WINNERS_FORMAT, toWinnersString(winners));
  }

  private static String toWinnersString(Winners winners) {
    StringBuilder sb = new StringBuilder();
    for (Car car : winners.getValues()) {
      sb.append(car.getName()).append(SEPARATOR_OF_WINNER_NAME);
    }
    return sb.substring(0, sb.lastIndexOf(SEPARATOR_OF_WINNER_NAME));
  }
}
