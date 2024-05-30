package view;

import java.util.List;
import model.Car;

public class OutputView {

    public static void printResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        int count = 1;
        System.out.print("최종 우승자 : " );
        for (Car car : cars) {
            System.out.print(car.getName());
            if (count < cars.size()) {
                System.out.print(", ");
                count++;
            }
        }
        System.out.println();
    }
}
