package cobi.car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RacingResult {
  private Cars cars;
  private List<Car> winnersCar;

  public RacingResult(Cars cars) {
    this.cars = cars;
    winnersCar = new ArrayList<>();
  }

  public Collection<Object> getWinnersCar() {
    return null;
  }
}
