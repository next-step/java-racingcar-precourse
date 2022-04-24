package racingcar.model.Car;

import racingcar.utils.Message;

import java.util.Objects;

public class Name {
  private final String name;

  public Name(String carName) {
    validateName(carName);
    this.name = carName;
  }
  private void validateName(String name) throws IllegalArgumentException{
    if(name == null || name.length() >= 6){
      throw new IllegalArgumentException(Message.LESS_MORE_NAME_ERROR);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Name name = (Name) o;
    return Objects.equals(this.name, name.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
