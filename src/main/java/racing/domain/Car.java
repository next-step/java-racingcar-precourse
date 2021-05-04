package racing.domain;

import java.util.Objects;
import java.util.Random;

public class Car {

  public static final int NAME_MAX_LENGTH = 5;
  private final String name;
  private final Position position;

  private Car(String name, Position position) {
    if (name.length() > NAME_MAX_LENGTH) {
      throw new IllegalArgumentException("이름은 5자 이하여야한다.");
    }
    this.name = name;
    this.position = position;
  }

  public Car(String name) {
    this(name, new Position());
  }

  public Car move(MoveStrategy strategy) {
    if (strategy.movable()) {
      return new Car(name, position.move());
    }
    return this;
  }

  public int position() {
    return position.getPosition();
  }

  public String name() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(name, car.name) && Objects.equals(position, car.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position);
  }
}
