package view;

import java.util.List;
import model.Car;

public class CarView {
  public void Print_CarNameAndForwardStep(Car c){
    String currentStep = "-".repeat(c.GetForwardStep());
    System.out.printf("%s : %s \n",c.GetCarName(),currentStep);

  }
  public void printWinners(List<Car> winners) {
    System.out.print("Winner: ");
    if (!winners.isEmpty()) {
      for (int i = 0; i < winners.size() - 1; i++) {
        System.out.printf("%s, ", winners.get(i).GetCarName());
      }
      System.out.print(winners.get(winners.size() - 1).GetCarName()); // Print the last winner without a comma
    }
  }

}
