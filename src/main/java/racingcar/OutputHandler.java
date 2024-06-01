package racingcar;

import java.util.List;

public class OutputHandler {

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printRaceResult(RacingGame racingGame) {
        List<String> winners = racingGame.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}