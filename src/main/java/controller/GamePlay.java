package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import model.CarDTO;
import model.GameStatusDTO;
import util.CarUtility;

public class GamePlay {

  private final CarUtility carUtility;
  private List<CarDTO> cars;
  private int playCount;
  private boolean winnerExists;


  public GamePlay() {
    carUtility = new CarUtility();
  }

  public void init() {
    System.out.println("실행 결과");
    cars = GameStatusDTO.cars;
    playCount = GameStatusDTO.playCount;
    winnerExists = GameStatusDTO.winnerExists;
  }

  public void play() {
    checkWinner();
    if (!winnerExists) {
      runCars();
      printCarsStatus();
      play();
      return;
    }
    printWinners();
  }

  public void checkWinner() {
    for (CarDTO car : cars) {
      if (car.getDistance() == playCount) {
        winnerExists = true;
        return;
      }
    }
  }

  public void runCars() {
    List<CarDTO> updatedCars = new ArrayList<>();
    for (CarDTO car : cars) {
      car.setDistance(car.getDistance() + carUtility.carMovement());
      updatedCars.add(car);
    }
    cars = updatedCars;
  }

  public void printCarsStatus() {
    for (CarDTO car : cars) {
      System.out.println(car);
    }
    System.out.println();
  }

  public void printWinners() {
    StringJoiner joiner = new StringJoiner(", ");
    System.out.print("최종 우승자 : ");
    for (CarDTO car : cars) {
      if (car.getDistance() == playCount) {
        joiner.add(car.getName());
      }
    }
    System.out.print(joiner);
  }
}
