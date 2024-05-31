package view;

import domain.Car;
import domain.Cars;

import java.util.List;

public class EndView {
    private static final String RESULT_NOTICE = "실행 결과";
    private static final String WINNER_NOTICE = "최종 우승자 : %s";
    private static final String WINNER_SEPARATOR = ", ";

    public void printResult(Cars cars) {
        ConsoleWriter.printlnMessage(RESULT_NOTICE);
        printCarsStatus(cars);
        ConsoleWriter.println();
    }

    private void printCarsStatus(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            printCarStatus(car);
        }
    }

    private void printCarStatus(Car car) {
        String name = car.carName();
        int moved = car.moved();
        ConsoleWriter.printlnMessage(name + " : " + "-".repeat(moved));
    }

    public void printWinners(List<String> winners) {
        ConsoleWriter.printlnFormat(
                WINNER_NOTICE,
                generateWinnerResult(winners)
        );
    }

    private String generateWinnerResult(List<String> winners) {
        return String.join(WINNER_SEPARATOR, winners);
    }
}
