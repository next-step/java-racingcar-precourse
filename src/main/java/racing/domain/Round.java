package racing.domain;

import java.util.Objects;

public class Round {
  private final Cars cars;

  private Round(Cars cars) {
    this.cars = cars;
  }

  public static Round record(Cars cars) {
    return new Round(cars);
  }

  public Cars getCars() {
    return cars;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Round round = (Round) o;
    return Objects.equals(cars, round.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars);
  }

  @Override
  public String toString() {
    return "Round{" +
            "cars=" + cars +
            '}';
  }
}
