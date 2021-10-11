package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import nextstep.utils.Randoms;
import racinggame.enums.Errors;
import racinggame.exception.RacingCarGameException;

public class RacingCar {
  private final Map<String,Integer> locationOfCars = new LinkedHashMap<>();

  public RacingCar(String racingCars) {
    String[] cars = racingCars.split(",");
    for(String car : cars) {
      validate(car);
      locationOfCars.put(car, 0);
    }
  }

  private void validate(String car) {
    if (car.length() > 5) {
      throw new RacingCarGameException(Errors.E00001.getMessage());
    }
  }

  public void race() {
    locationOfCars.keySet()
        .forEach(this::countGame);
  }

  private void countGame(String car) {
    int random = Randoms.pickNumberInRange(0,9);
    if(random >= 4) {
      locationOfCars.merge(car, 1, Integer::sum);
    }
  }

  public Map<String, Integer> getLocationOfCars() {
    return Collections.unmodifiableMap(locationOfCars);
  }

  public String winner() {
    int max = getMaxLocation();
    List<String> winners = new ArrayList<>();

    locationOfCars.forEach((key, value) -> {
      if (value == max) {
        winners.add(key);
      }
    });

    return String.join(",", winners);
  }

  private int getMaxLocation() {
    int result = Integer.MIN_VALUE;
    for(int v : locationOfCars.values()) {
      result = Math.max(v, result);
    }

    return result;
  }
}
