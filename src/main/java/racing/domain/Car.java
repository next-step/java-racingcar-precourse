package racing.domain;

import java.util.Random;

public class Car {

  private final String name;
  private final Position position;

  private Car(String name, Position position) {
    if (name.length() > 5) {
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
}
