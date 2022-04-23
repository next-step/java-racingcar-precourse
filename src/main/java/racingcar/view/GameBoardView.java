package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class GameBoardView {
    public static void start() {
        System.out.println("실행 결과");
    }

    public static void display(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s: %s\n", car.getName(), car.getPosition());
        }
        System.out.println();
    }
}
