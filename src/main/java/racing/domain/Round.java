package racing.domain;

import java.util.Objects;

public class Round {
  private final Cars cars;
  private final int countOfRemaining;

  private Round(Cars cars, int countOfRemaining) {
    this.cars = cars;
    this.countOfRemaining = countOfRemaining;
  }

  public static Round record(Cars cars, int countOfRemaining) {
    return new Round(cars, countOfRemaining);
  }

  public Cars getCars() {
    return cars;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Round round = (Round) o;
    return countOfRemaining == round.countOfRemaining && Objects.equals(cars, round.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars, countOfRemaining);
  }

  @Override
  public String toString() {
    return "Round{" +
            "cars=" + cars +
            ", countOfRemaining=" + countOfRemaining +
            '}';
  }
}
