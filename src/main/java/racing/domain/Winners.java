package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Winners {
  private final List<Car> values;

  private Winners(List<Car> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Winners generate(final Round round) {
    return new Winners(findWinners(round.getCars()));
  }

  private static List<Car> findWinners(Cars cars) {
    List<Car> winners = new ArrayList<>();
    Position positionOfWinner = cars.getMaxPosition();
    for (Car car : cars.getValues()) {
      addWinner(winners, car, isWinner(positionOfWinner, car));
    }
    return winners;
  }

  private static void addWinner(List<Car> winners, Car car, boolean isWinner) {
    if (isWinner) {
      winners.add(car);
    }
  }

  private static boolean isWinner(Position positionOfWinner, Car car) {
    return positionOfWinner.equals(new Position(car.getPosition()));
  }

  public List<Car> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Winners winners = (Winners) o;
    return Objects.equals(values, winners.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Winners{" +
            "values=" + values +
            '}';
  }
}
