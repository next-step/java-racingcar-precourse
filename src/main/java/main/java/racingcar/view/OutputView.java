package main.java.racingcar.view;

import main.java.racingcar.domain.Cars;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMovingResult(Cars cars) {
        System.out.println(cars);
        System.out.println();
    }
}
