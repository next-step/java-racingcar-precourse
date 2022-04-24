package racingcar.model.Car;

public class Car {
  private final Name name;
  private final Position position;

  public Car(String carName) {
    name = new Name(carName);
    position = new Position();
  }

  public Name getName() {
    return name;
  }

  public void move() {
    position.move();
  }

  public Position getPosition() {
    return position;
  }

  @Override
  public String toString() {
    return String.format("%s : %s", name, position);
  }
}
