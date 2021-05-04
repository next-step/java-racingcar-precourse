package racing.domain;

import java.util.Random;

public class Car {

  private static Random RANDOM = new Random();
  private static final int BOUND = 10;
  private static final int MOVE_CONDITION = 4;

  private final String name;
  private final Position position;

  private Car(String name, Position position) {
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

  public Car move() {
    return move(() -> RANDOM.nextInt(BOUND) >= MOVE_CONDITION);
  }

  public int position() {
    return position.getPosition();
  }
}
