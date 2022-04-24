package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Referee {
     public static String judgeWinners(List<Car> cars) {
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
