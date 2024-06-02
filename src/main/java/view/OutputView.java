package view;

import model.Car;

import java.util.List;

public class OutputView {
    public void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print("winner: ");
        StringBuilder result = new StringBuilder();
        for (Car winner : winners) {
            result.append(winner.getName()).append(", ");
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        System.out.println(result.toString());
    }
}
