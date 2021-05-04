package racing.view;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import racing.domain.Cars;

public class ResultView {

  private static final String MOVE_MARK = "_";
  private static final String WINNER_MESSAGE_FORMAT = "%s 가 최종 우승했습니다.";
  private static final String SEPARATOR = ", ";

  public void print(Cars cars) {
    List<String> carNames = cars.getNames();
    Map<String, Integer> result = cars.result();
    for (String carName : carNames) {
      int position = result.get(carName);
      System.out.printf("%s : %s %n", carName, getPositionString(position));
    }
  }

  private String getPositionString(int position) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < position; i++) {
      builder.append(MOVE_MARK);
    }
    return builder.toString();
  }

  public void printWinner(Cars winners){
    List<String> names = winners.getNames();
    String winnersName = StringUtils.join(names, SEPARATOR);
    System.out.printf(WINNER_MESSAGE_FORMAT, winnersName);
  }

}
