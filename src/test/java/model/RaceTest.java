package model;

import RacingCar.Model.Car;
import RacingCar.Model.Race;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {

  @Test
  @DisplayName("자동차 경주 초기화 테스트")
  void testRaceInitialization() {
    List<String> carNames = List.of("pobi", "woni", "jun");
    Race race = new Race(carNames);
    List<Car> cars = race.getCars();

    assertEquals(3, cars.size(), "자동차 수는 입력된 이름 수와 같아야 합니다.");
    assertEquals("pobi", cars.get(0).getName(), "첫 번째 자동차 이름은 pobi이어야 합니다.");
    assertEquals("woni", cars.get(1).getName(), "두 번째 자동차 이름은 woni이어야 합니다.");
    assertEquals("jun", cars.get(2).getName(), "세 번째 자동차 이름은 jun이어야 합니다.");
  }

  @Test
  @DisplayName("자동차 경주 이동 테스트")
  void testMoveCars() {
    List<String> carNames = List.of("pobi", "woni", "jun");
    Race race = new Race(carNames);
    List<Car> cars = race.getCars();

    for (Car car : cars) {
      car.move(4); // 모두 움직이도록 설정
    }

    assertEquals(1, cars.get(0).getPosition(), "pobi는 1칸 이동해야 합니다.");
    assertEquals(1, cars.get(1).getPosition(), "woni는 1칸 이동해야 합니다.");
    assertEquals(1, cars.get(2).getPosition(), "jun은 1칸 이동해야 합니다.");
  }

  @Test
  @DisplayName("우승자 계산 테스트")
  void testGetWinner() {
    List<String> carNames = List.of("pobi", "woni", "jun");
    Race race = new Race(carNames);
    List<Car> cars = race.getCars();

    cars.get(0).move(4);
    cars.get(1).move(4);
    cars.get(1).move(4);
    cars.get(2).move(4);

    List<Car> winners = race.getWinner();
    assertEquals(1, winners.size(), "우승자는 한 명이어야 합니다.");
    assertEquals("woni", winners.get(0).getName(), "우승자는 woni이어야 합니다.");
  }
}
