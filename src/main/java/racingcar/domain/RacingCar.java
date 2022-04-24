package racingcar.domain;

public class RacingCar {
  private int GO_COUNT = 0;
  private String CAR_NAME = "";

  public RacingCar(String carName) {
    GO_COUNT = 0;
    CAR_NAME = carName;
  }

  public int getGoCount() {
    return this.GO_COUNT;
  }

  public String getCarName() {
    return this.CAR_NAME;
  }

  public static boolean addGoCount(RacingCar racingCar, int cnt) {
    racingCar.GO_COUNT += cnt;
    racingCar.printRacingCar();
    return true;
  }

  public void printRacingCar() {
    System.out.println(this.CAR_NAME + " : " + this.GO_COUNT);
  }
}
