package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.exception.RacingCarGameExceptionHandler;
import racingcar.view.RacingCarGameView;
import racingcar.view.userinferface.ConsoleUserInterface;
import racingcar.view.userinferface.GameUserInterface;
import racingcar.view.userinferface.printer.ConsolePrinter;
import racingcar.view.userinferface.scanner.ConsoleScanner;

public class Application {
    public static void main(String[] args) {
        GameUserInterface gameUserInterface = new ConsoleUserInterface(new ConsolePrinter(), new ConsoleScanner());
        setGlobalExceptionHandler(gameUserInterface);
        createRacingCarGameController(gameUserInterface).startGame();
    }

    private static RacingCarGameController createRacingCarGameController(GameUserInterface gameUserInterface) {
        RacingCarGameView gameView = new RacingCarGameView(gameUserInterface);

        RacingCarGameController gameController = new RacingCarGameController(gameView);
        return gameController;
    }

    private static void setGlobalExceptionHandler(GameUserInterface gameUserInterface) {
        RacingCarGameExceptionHandler exceptionHandler = new RacingCarGameExceptionHandler(gameUserInterface);
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
    }
}
