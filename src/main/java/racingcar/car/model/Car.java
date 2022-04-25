package racingcar.car.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.car.exception.CarNameLengthException;

public class Car implements Comparable<Car> {

  public static final int MOVE_CONDITION_STANDARD = 4;

  public static final int NAME_MAX_LENGTH = 5;
  public static final String HISTORY_DELIMITER = "-";

  private final String name;
  private final List<String> history;

  public Car(String name) {
    validate(name);
    this.name = name;
    this.history = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getHistory() {
    return String.join("", history);
  }

  public int getHistorySize() {
    return history.size();
  }

  public void runOrStopByNumber(int number) {
    if (number >= MOVE_CONDITION_STANDARD) {
      history.add(HISTORY_DELIMITER);
    }
  }

  private void validate(String name) {
    validateLength(name);
  }


  private void validateLength(String input) {
    if (input.length() > NAME_MAX_LENGTH) {
      throw new CarNameLengthException();
    }
  }

  @Override
  public int compareTo(Car o) {
    return o.history.size() - history.size();
  }
}
