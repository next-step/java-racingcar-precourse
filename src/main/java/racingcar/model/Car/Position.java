package racingcar.model.Car;

import java.util.Objects;

public class Position {
  public static final String MOVE_WORD = "-";
  private int value = 0;

  public Position() {
  }

  public Position(int value) {
    this.value = value;
  }

  public void move() {
    value++;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position that = (Position) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder(value);
    for (int i = 0; i < value; ++i) {
      b.append(MOVE_WORD);
    }
    return b.toString();
  }
}
