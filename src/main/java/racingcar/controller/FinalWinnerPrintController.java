package racingcar.controller;

import racingcar.controller.message.printer.MessagePrinter;
import racingcar.model.finalwinner.FinalWinnersOfGame;
import racingcar.model.racing.car.RacingCarsInGame;
import racingcar.view.Message;
import racingcar.view.finalwinner.message.FinalWinnerResultMessage;
import racingcar.view.finalwinner.message.FinalWinnerStringConstructor;

public class FinalWinnerPrintController {
    private final RacingCarsInGame racingCarsInGame;

    public FinalWinnerPrintController(RacingCarsInGame racingCarsInGame) {
        this.racingCarsInGame = racingCarsInGame;
    }

    public void run() {
        FinalWinnersOfGame finalWinnersOfGame = new FinalWinnersOfGame(racingCarsInGame);
        FinalWinnerStringConstructor finalWinnerStringConstructor =
                new FinalWinnerStringConstructor(finalWinnersOfGame);
        String finalWinnersString = finalWinnerStringConstructor.construct();
        Message finalWinnerResultMessage = new FinalWinnerResultMessage(finalWinnersString);
        MessagePrinter.println(finalWinnerResultMessage);
    }
}
