package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

  private Race race;
  private List<Car> cars;

  @BeforeEach
  void setUp() {
    cars = new ArrayList<>();
    cars.add(new Car("pobi",1, ""));
    cars.add(new Car("bob",0, ""));
    cars.add(new Car("woni",0, ""));
    race = new Race(cars, 1);
  }

  @Test
  @DisplayName("레이스 최종 우승자 출력")
  void 우승자판별() {
    assertThat(race.getChampionName().equalsIgnoreCase("pobi")).isTrue();
  }

}
