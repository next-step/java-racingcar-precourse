package DTO;

public class CarDTO {
  private String name;
  private int position;

  public CarDTO(String name, int position) {
    if (name == null || name.isEmpty() || name.length() > 5) {
      throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하이어야 합니다.");
    }
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }
}

