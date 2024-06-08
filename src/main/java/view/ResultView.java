package view;

import DTO.CarDTO;

import java.util.List;

public class ResultView {

  public void printRaceStatus(List<CarDTO> carStatuses) {
    for (CarDTO carDto : carStatuses) {
      System.out.println(carDto.getName() + " : " + "-".repeat(carDto.getPosition()));
    }
    System.out.println();
  }

  public void printWinners(List<String> winners) {
    System.out.println("최종 우승자 : " + String.join(", ", winners));
  }
}
