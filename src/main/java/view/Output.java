package view;

import java.util.List;
import model.Car;

public class Output {
    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPos()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(",", winner));
    }
}
