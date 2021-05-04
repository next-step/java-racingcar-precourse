package racing.view;

import java.util.List;
import java.util.Map;

public class ResultView {

  private static final String MOVE_MARK = "_";

  public void print(List<String> carNames, Map<String, Integer> result) {
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

}
