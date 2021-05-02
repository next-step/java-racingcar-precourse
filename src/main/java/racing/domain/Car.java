package racing.domain;

import java.util.Objects;

public class Car {
  private final Name name;
  private final Position position;

  public Car(final String name) {
    this.name = new Name(name);
    this.position = Position.create();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Objects.equals(name, car.name) && Objects.equals(position, car.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position);
  }

  @Override
  public String toString() {
    return "Car{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
  }
}
