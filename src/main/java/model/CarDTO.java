package model;

public class CarDTO {

  private final String name;
  private int distance;

  public CarDTO(String name) {
    this.name = name;
    this.distance = 0;
  }

  public String getName() {
    return name;
  }

  public int getDistance() {
    return distance;
  }

  public void move(boolean value) {
    if (value) {
      this.distance++;
    }
  }

  @Override
  public String toString() {
    return name + " : " + "-".repeat(distance);
  }
}
