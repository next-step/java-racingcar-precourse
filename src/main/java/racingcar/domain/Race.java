package racingcar.domain;

import java.util.List;

public class Race {

  private List<Car> cars;
  private Integer round;

  final Integer MIN_SUBSTRING_INDEX = 0;
  final String BLANK_CAR_NAME = "";

  public Race(List<Car> cars, Integer round) {
    this.cars = cars;
    this.round = round;
  }

  public List<Car> getCars() {
    return this.cars;
  }

  public Integer getRound() {
    return this.round;
  }

  public void addRound() {
    this.round++;
  }

  public Integer getMaxDistance() {
    Integer maxDistance = 0;
    for (Car car : this.cars) {
      maxDistance = compareToDistances(maxDistance, car);
    }
    return maxDistance;
  }

  private Integer compareToDistances(Integer maxDistance, Car compareCar) {
    if (maxDistance < compareCar.getDistance()) {
      return compareCar.getDistance();
    }
    return maxDistance;
  }
  public String getChampionName() {
    String championNames = "";
    Integer maxDistance = getMaxDistance();
    for (Car car : this.cars) {
      championNames += getTopRankCar(maxDistance, car);
    }
    return championNames.substring(MIN_SUBSTRING_INDEX, championNames.length()-2);
  }

  private String getTopRankCar(Integer maxDistance, Car car) {
    if (maxDistance == car.getDistance()) {
      return car.getName() + ", ";
    }
    return BLANK_CAR_NAME;
  }

}
