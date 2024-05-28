package view;

import model.Car;

import java.util.List;

public class OutputView {
    public static void printRaceState(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
