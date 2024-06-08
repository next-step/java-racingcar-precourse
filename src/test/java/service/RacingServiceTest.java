package service;

import DTO.CarDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {

  @Test
  public void initializeGame() {
    RacingService racingService = new RacingService();
    String[] carNames = {"pobi", "woni", "jun"};
    racingService.initializeGame(carNames);

    List<CarDTO> carStatuses = racingService.getCarStatuses();
    assertThat(carStatuses).hasSize(3);
    assertThat(carStatuses).extracting(CarDTO::getName).containsExactly("pobi", "woni", "jun");
    assertThat(carStatuses).extracting(CarDTO::getPosition).containsExactly(0, 0, 0);
  }

  @Test
  public void race() {
    RacingService racingService = new RacingService();
    String[] carNames = {"pobi", "woni", "jun"};
    racingService.initializeGame(carNames);

    racingService.race(5);

    List<CarDTO> carStatuses = racingService.getCarStatuses();
    for (CarDTO CarDTO : carStatuses) {
      assertThat(CarDTO.getPosition()).isGreaterThanOrEqualTo(0);
    }
  }

  @Test
  public void getWinners() {
    RacingService racingService = new RacingService();
    String[] carNames = {"pobi", "woni", "jun"};
    racingService.initializeGame(carNames);

    racingService.race(5);

    List<String> winners = racingService.getWinners();
    assertThat(winners).isNotEmpty();

    List<CarDTO> carStatuses = racingService.getCarStatuses();
    int maxPosition = carStatuses.stream()
            .mapToInt(CarDTO::getPosition)
            .max()
            .orElse(0);

    for (String winner : winners) {
      CarDTO winningCar = carStatuses.stream()
              .filter(carDto -> carDto.getName().equals(winner))
              .findFirst()
              .orElse(null);

      assertThat(winningCar).isNotNull();
      assertThat(winningCar.getPosition()).isEqualTo(maxPosition);
    }
  }
}
