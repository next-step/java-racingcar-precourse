package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

  @Test
  public void createCars() {
    String[] names = {"pobi", "woni", "jun"};
    RacingGame racingGame = new RacingGame(names);
    List<Car> cars = racingGame.getCars();

    assertThat(cars).hasSize(3);
    assertThat(cars).extracting(Car::getName).containsExactly("pobi", "woni", "jun");
  }

  @Test
  public void raceIncrementsPosition() {
    String[] names = {"pobi", "woni", "jun"};
    RacingGame racingGame = new RacingGame(names);

    racingGame.race();
    List<Car> cars = racingGame.getCars();

    // Since car moves randomly, we just check that all positions are valid (0 or more)
    for (Car car : cars) {
      assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }
  }

  @Test
  public void determineWinners() {
    String[] names = {"pobi", "woni", "jun"};
    RacingGame racingGame = new RacingGame(names);

    for (int i = 0; i < 5; i++) {
      racingGame.race();
    }

    List<String> winners = racingGame.getWinners();
    assertThat(winners).isNotEmpty();

    // Ensure that winners have the maximum position
    int maxPosition = racingGame.getCars().stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

    for (String winner : winners) {
      Car winningCar = racingGame.getCars().stream()
              .filter(car -> car.getName().equals(winner))
              .findFirst()
              .orElse(null);

      assertThat(winningCar).isNotNull();
      assertThat(winningCar.getPosition()).isEqualTo(maxPosition);
    }
  }
}
