package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.utils.MessagePrinter;
import racingcar.view.RacingGame;

public class Application {
    public static void main(String[] args) {
        final RacingGameService racingGameService = new RacingGameService();
        final RacingGameController racingGameController = new RacingGameController(racingGameService);
        final MessagePrinter messagePrinter = new MessagePrinter();
        final RacingGame racingGame = new RacingGame(racingGameController, messagePrinter);
        racingGame.start();
    }
}
