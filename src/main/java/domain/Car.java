package domain;

public class Car {
  private String name;
  private int position;

  public Car(String name) {
    if (name == null || name.isEmpty() || name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
    }
    this.name = name;
    this.position = 0;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public void move() {
    position++;
  }

  public boolean canMove(int randomValue) {
    return randomValue >= 4;
  }
}
