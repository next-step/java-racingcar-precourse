package view;

import java.util.List;
import model.Car;

public class OutputView {

    public static void printResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public static void printWinner() {

    }
}
