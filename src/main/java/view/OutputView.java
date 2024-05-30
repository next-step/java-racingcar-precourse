package view;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Cars;

public class OutputView {

    public static void printDefault() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : "
                + "-".repeat(Math.max(0, car.getCount())
            ));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars, int maxMoved) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getCount() == maxMoved) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));


    }
}
