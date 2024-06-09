package view;

import java.util.List;
import model.Car;

public class OutputView {

    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
