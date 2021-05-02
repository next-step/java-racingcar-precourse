package racing.domain;

import racing.exception.InvalidCarNameLengthException;

import java.util.Objects;

public class Car {
  private static final int MAX_OF_NAME_LENGTH = 5;

  private final String value;

  public Car(final String value) {
    checkNameLength(value);
    this.value = value;
  }

  private void checkNameLength(final String value) {
    if (value.length() > MAX_OF_NAME_LENGTH) {
      throw new InvalidCarNameLengthException(MAX_OF_NAME_LENGTH);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Objects.equals(value, car.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Car{" +
            "value='" + value + '\'' +
            '}';
  }
}
