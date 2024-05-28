package view;

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
}
