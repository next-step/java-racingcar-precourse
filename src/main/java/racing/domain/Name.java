package racing.domain;

import racing.exception.NameLengthExceedException;

import java.util.Objects;

public class Name {
  private static final int MAX = 5;

  private final String value;

  public Name(String value) {
    checkValidLength(value);
    this.value = value;
  }

  private void checkValidLength(final String value) {
    if (value.length() > MAX) {
      throw new NameLengthExceedException(MAX);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Name name = (Name) o;
    return Objects.equals(value, name.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Name{" +
            "value='" + value + '\'' +
            '}';
  }
}
