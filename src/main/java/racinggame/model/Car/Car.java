package racinggame.model.Car;

public class Car {
  private final CarName name;
  private final CarPosition position;

  public Car(String carName) {
    name = new CarName(carName);
    position = new CarPosition();
  }

  public CarName getName() {
    return name;
  }

  public void move() {
    position.move();
  }

  public CarPosition getPosition() {
    return position;
  }

  @Override
  public String toString() {
    return String.format("%s : %s", name, position);
  }
}
