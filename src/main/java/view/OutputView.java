package view;

import model.Car;
import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder status = new StringBuilder();
            status.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                status.append("-");
            }
            System.out.println(status.toString());
        }
        System.out.println(); // 빈 줄로 회차 구분
    }
}
