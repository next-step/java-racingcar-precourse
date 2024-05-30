package view;

import java.util.List;
import model.Car;

public class OutputView {

    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void printRoundOutput(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getStep(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
