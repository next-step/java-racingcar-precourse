package model;

public class CarsDTO {

  private String[] carNames;

  public CarsDTO(String[] carNames) {
    this.carNames = carNames;
  }

  public String[] getCarNames() {
    return carNames;
  }

  public void setCarNames(String[] carNames) {
    this.carNames = carNames;
  }
}
