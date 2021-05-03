package racingCar.domain;

public class RacingGame {

  private final Cars cars;
  private final TryCount tryCount;

  public RacingGame(String[] carNames, int tryCount) {
    this.cars = new Cars(carNames);
    this.tryCount = new TryCount(tryCount);
  }
}
