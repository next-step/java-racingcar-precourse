package service;

import DTO.CarDTO;
import domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {
  private RacingGame racingGame;

  public void initializeGame(String[] carNames) {
    racingGame = new RacingGame(carNames);
  }

  public void race(int attempts) {
    for (int i = 0; i < attempts; i++) {
      racingGame.race();
    }
  }

  public List<CarDTO> getCarStatuses() {
    return racingGame.getCars().stream()
            .map(car -> new CarDTO(car.getName(), car.getPosition()))
            .collect(Collectors.toList());
  }

  public List<String> getWinners() {
    return racingGame.getWinners();
  }
}
