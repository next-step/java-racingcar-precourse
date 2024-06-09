package main.java.racingcar.view;

import main.java.racingcar.domain.Car;
import main.java.racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

import static main.java.racingcar.message.ViewMessage.WINNER_RESULT_DELIMITER;
import static main.java.racingcar.message.ViewMessage.WINNER_RESULT_FORMAT;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMovingResult(Cars cars) {
        System.out.println(cars);
        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        String winnerStr = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_RESULT_DELIMITER));
        System.out.printf(WINNER_RESULT_FORMAT, winnerStr);
    }
}
