package view;

import domain.Car;
import domain.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";
    public static final String WINNER_PRINT_SEPARATOR = ", ";

    public static void printErrorMessage(Exception exception) {
        System.out.println(ERROR_PREFIX + " " + exception.getMessage());
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + " " + message);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printRacingResult(RacingCars rc) {
        for (Car car : rc.getCars()) {
            printCarResult(car);
        }
        System.out.println();
    }

    private static void printCarResult(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners.stream().map(Car::getCarName)
                .collect(Collectors.joining(WINNER_PRINT_SEPARATOR)));
    }
}
