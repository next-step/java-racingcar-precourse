package racing.domain;

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
    String[] arr = input.split(SEPARATOR_OF_NAME);
    List<Car> values = new ArrayList<>(arr.length);
    for (String str : arr) {
      values.add(new Car(str));
    }
    return new Cars(values);
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
