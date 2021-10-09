package racinggame.view;

import racinggame.domain.Car;

import java.util.List;

public class CarView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.status());
        }
    }

    public void printResult(String name) {
        System.out.println("최종 우승자는 " + name + " 입니다.");
    }

    public void printLine() {
        System.out.println();
    }
}
