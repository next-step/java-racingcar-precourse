package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import model.CarDTO;
import model.GameStatusDTO;
import util.CarUtility;
import view.OutputView;

public class GamePlay {

  private final CarUtility carUtility;
  private final OutputView outputView;
  private int playCount;
  private boolean winnerExists;


  public GamePlay() {
    carUtility = new CarUtility();
    outputView = new OutputView();
  }

  public void init() {
    outputView.initPrintCarsStatus();
    playCount = GameStatusDTO.playCount;
    winnerExists = GameStatusDTO.winnerExists;
  }

  public void play() {
    checkWinner();
    if (!winnerExists) {
      runCars();
      outputView.printCarsStatus();
      play();
      return;
    }
    setWinners();
    outputView.printWinners();
  }

  public void checkWinner() {
    for (CarDTO car : GameStatusDTO.cars) {
      if (car.getDistance() == playCount) {
        winnerExists = true;
        return;
      }
    }
  }

  public void runCars() {
    List<CarDTO> updatedCars = new ArrayList<>();
    for (CarDTO car : GameStatusDTO.cars) {
      car.move(carUtility.carMovement());
      updatedCars.add(car);
    }
    GameStatusDTO.cars = updatedCars;
  }

  public void setWinners() {
    List<String> winners = new ArrayList<>();
    for (CarDTO car : GameStatusDTO.cars) {
      if (car.getDistance() == playCount) {
        winners.add(car.getName());
      }
    }
    GameStatusDTO.winners = winners;
  }
}
