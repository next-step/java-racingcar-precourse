package racing.domain;

import java.util.Objects;

public class Position {

  private static final int MIN = 0;
  private static final int MOVE_LENGTH = 1;

  private final int position;

  private Position(int position) {
    if (position < MIN) {
      throw new IllegalArgumentException("position 은 0이상이어야 한다.");
    }
    this.position = position;
  }

  public Position() {
    this(MIN);
  }

  public Position move() {
    return new Position(position + MOVE_LENGTH);
  }

  public int getPosition() {
    return position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position1 = (Position) o;
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }
}
