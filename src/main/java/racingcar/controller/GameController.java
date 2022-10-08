package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.car.CarCollection;
import racingcar.model.game.Board;
import racingcar.model.game.BoardDto;
import racingcar.model.game.Count;
import racingcar.view.GameInputScreen;
import racingcar.view.GameOutputScreen;

public class GameController {

    public void start() {
        GameInputScreen.printCarEntry();
        CarCollection racingCars = requestRacingCarCollection();
        GameInputScreen.printRetryCount();
        Count tryCount = requestTryCount();
        Board board = new Board(racingCars, tryCount);
        board.run();
        BoardDto boardDto = new BoardDto(board);
        GameOutputScreen.printRacingResult(boardDto);
        GameOutputScreen.printWinners(boardDto);
    }

    private Count requestTryCount() {
        while (true) {
            try {
                String tryCount = Console.readLine();
                return new Count(tryCount);
            } catch (IllegalArgumentException exception) {
                GameOutputScreen.printErrorMessage(exception);
            }
        }
    }

    private CarCollection requestRacingCarCollection() {
        while (true) {
            try {
                String carNames = Console.readLine();
                return CarCollection.create(carNames);
            } catch (IllegalArgumentException exception) {
                GameOutputScreen.printErrorMessage(exception);
            }
        }
    }

}
