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
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> carNames) {
        System.out.print("최종 우승자 : " + String.join(", ", carNames));
    }

}
