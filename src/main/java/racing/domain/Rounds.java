package racing.domain;

import racing.exception.InvalidRoundTotalSizeException;
import racing.rule.OperationMoveRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rounds {
  public static final int MIN = 1;

  private final List<Round> values;

  private Rounds(List<Round> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Rounds generate(int countOfTotal, Cars cars) {
    checkRoundTotalSize(countOfTotal);
    List<Round> result = new ArrayList<>(countOfTotal);
    while (result.size() < countOfTotal) {
      cars = cars.race(new OperationMoveRule());
      result.add(Round.record(cars));
    }
    return new Rounds(result);
  }

  private static void checkRoundTotalSize(int countOfTotal) {
    if (countOfTotal < MIN) {
      throw new InvalidRoundTotalSizeException(MIN);
    }
  }

  public Round finalRound() {
    return values.get(values.size() - 1);
  }

  public List<Round> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Rounds rounds = (Rounds) o;
    return Objects.equals(values, rounds.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Rounds{" +
            "values=" + values +
            '}';
  }
}
