import java.util.Scanner;
import model.CarRepository;
import controller.CarController;
import view.CarView;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CarRepository carRepository = new CarRepository();
    CarView carView = new CarView();
    CarController carController = new CarController(carRepository, carView);

    String carNamesInput = getValidCarNamesInput(scanner);
    carController.AddCars(carNamesInput);

    int trials = getValidTrialsInput(scanner);
    System.out.println("Results of the race:");
    for (int i = 0; i < trials; i++) {
      carController.Trial();
    }
    carController.printWinners();

    scanner.close();
  }

  private static String getValidCarNamesInput(Scanner scanner) {
    while (true) {
      System.out.println("Enter the names of the cars to race (separated by commas):");
      String input = scanner.nextLine();
      if (isValidCarNamesInput(input)) {
        return input;
      } else {
        System.out.println("[ERROR] Invalid input. Please enter names separated by commas with each name having at least 5 characters.");
      }
    }
  }

  private static boolean isValidCarNamesInput(String input) {
    if (input == null || input.isEmpty()) {
      return false;
    }

    String[] carNames = input.split(",");
    for (String carName : carNames) {
      if (carName.trim().length() > 5) {
        return false;
      }
    }
    return true;
  }


  private static int getValidTrialsInput(Scanner scanner) {
    while (true) {
      System.out.println("How many times do you want to run the race?");
      try {
        int trials = Integer.parseInt(scanner.nextLine());
        if (trials > 0) {
          return trials;
        } else {
          System.out.println("[ERROR] Number of trials must be greater than 0.");
        }
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] Number of trials must be a valid integer.");
      }
    }
  }
}
