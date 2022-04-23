package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameBoardView {
    public static void start() {
        System.out.println("실행 결과");
    }

    public static void display(List<Car> cars) {
        for (Car car : cars)
            System.out.printf("%s : %s\n", car.getName(), car.drawCurrentPosition());
        System.out.println();
    }

    public static void declareWinners(List<Car> cars) {
        System.out.printf("최종 우승자: %s", winners(cars));
    }

    private static String winners(List<Car> cars) {
        // 정렬
        cars.sort(Comparator.comparingInt(Car::getPosition));

        List<String> winners = new ArrayList<>();

        Car winner = cars.get(cars.size() - 1);
        for (Car car : cars)
            if (car.getPosition() == winner.getPosition())
                winners.add(car.getName());
        return String.join(",", winners);
    }
}
