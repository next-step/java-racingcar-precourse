package racing.domain;

import racing.exception.PositionLessThenMinValueException;

import java.util.Objects;

public class Position {
  public static final int MIN = 0;

  private final int value;

  public Position(int value) {
    checkMoreThenMinimumValue(value);
    this.value = value;
  }

  private void checkMoreThenMinimumValue(int value) {
    if (value < MIN) {
      throw new PositionLessThenMinValueException(MIN);
    }
  }

  public static Position create() {
    return new Position(MIN);
  }

  public Position move() {
    return new Position(value + 1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return value == position.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Position{" +
            "value=" + value +
            '}';
  }
}
