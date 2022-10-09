package racingcar.controller;


import racingcar.exception.DuplicatedCarNameException;
import racingcar.exception.InvalidCarNameSizeException;
import racingcar.exception.InvalidRaceCountFormatException;
import racingcar.exception.InvalidRaceCountRangeException;
import racingcar.model.Game;
import racingcar.model.Names;
import racingcar.model.RaceCount;
import racingcar.view.InputConsole;
import racingcar.view.OutputConsole;

public class GameController {
    public static void run() {
        Game game = new Game(readNames(), readCount());

        for (int currentCount = 0; currentCount < game.getRaceCount(); currentCount++) {
            OutputConsole.printRaceResult(game.race());
        }
        OutputConsole.printWinner(game.getWinners());
    }

    private static Names readNames() {
        try {
            return InputConsole.readCarNames();
        } catch (InvalidCarNameSizeException | DuplicatedCarNameException exception) {
            OutputConsole.printErrorView(exception.getMessage());
            return readNames();
        }
    }

    private static RaceCount readCount() {
        try {
            return InputConsole.readRaceCount();
        } catch (InvalidRaceCountFormatException | InvalidRaceCountRangeException exception) {
            OutputConsole.printErrorView(exception.getMessage());
            return readCount();
        }
    }
}
