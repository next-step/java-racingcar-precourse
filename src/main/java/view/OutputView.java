package view;

import model.Car;
import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            String status = car.getName() + " : "
                + "-".repeat(Math.max(0, car.getPosition()));
            printMessage(status);
        }
        printMessage(""); // 빈 줄로 회차 구분
    }
}
