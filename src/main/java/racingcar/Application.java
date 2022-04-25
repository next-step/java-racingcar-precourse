package racingcar;

import racingcar.car.controller.GameManager;
import racingcar.printer.SystemPrinter;

public class Application {
    public static void main(String[] args) {
        final GameManager gameManager = new GameManager(
            new SystemPrinter()
        );

        gameManager.start();
    }
}
