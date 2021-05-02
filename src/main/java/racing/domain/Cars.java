package racing.domain;

import racing.rule.MoveRule;
import racing.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {
  private static final String SEPARATOR_OF_NAME = ",";

  private final List<Car> values;

  private Cars(List<Car> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Cars generateFromInputString(String input) {
    return new Cars(StringUtil.toList(input, SEPARATOR_OF_NAME, Car::new));
  }

  public Cars race(MoveRule moveRule) {
    List<Car> racingCars = new ArrayList<>();
    for (Car car : values) {
      racingCars.add(car.move(moveRule));
    }
    return new Cars(racingCars);
  }

  public List<Car> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cars cars = (Cars) o;
    return Objects.equals(values, cars.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Cars{" +
            "values=" + values +
            '}';
  }
}
