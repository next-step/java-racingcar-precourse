package view;
import java.util.List;
import java.util.stream.Collectors;
import model.Car;

public class ResultView {
    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
