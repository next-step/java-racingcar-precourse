package view;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Cars;

public class OutputView {

    public static void printResult(List<Car> cars) {
        for (Car car: cars) {
            StringBuilder progress = new StringBuilder();
            progress.append("-".repeat(Math.max(0, car.getCount())));
            System.out.println(car.getName() + " : " + progress);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars, int maxMoved) {
        List<String> winners = new ArrayList<>();

        for (Car car: cars) {
            if (car.getCount() == maxMoved) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));


    }
}
