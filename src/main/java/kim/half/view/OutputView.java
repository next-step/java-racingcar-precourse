package kim.half.view;

import java.util.List;
import kim.half.model.Car;

public class OutputView {

    public void printProgressStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream()
            .map(Car::getName)
            .toArray(String[]::new));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
