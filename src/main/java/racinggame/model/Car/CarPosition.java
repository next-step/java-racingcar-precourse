package racinggame.model.Car;

import java.util.Objects;

public class CarPosition {
  public static final String MOVE_WORD = "-";
  private int value = 0;

  public void move() {
    value++;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarPosition that = (CarPosition) o;
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
