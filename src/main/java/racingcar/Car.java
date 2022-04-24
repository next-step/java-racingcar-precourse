package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

  String name;
  int distance;

  public Car(String name, int distance) {
    this.distance = distance;
    this.name = name;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void move() {
    if (Randoms.pickNumberInRange(0, 9) > 4) {
      this.distance++;
    }
  }

}
