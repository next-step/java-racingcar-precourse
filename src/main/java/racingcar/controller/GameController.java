package racingcar.controller;

import static racingcar.view.OutputView.printGameResult;
import static racingcar.view.OutputView.printInputCarName;
import static racingcar.view.OutputView.printInputTryCount;
import static racingcar.view.OutputView.printVictory;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.TryCount;
import racingcar.domain.VictoryCars;
import racingcar.domain.input.Input;
import racingcar.domain.input.InputCarName;
import racingcar.exception.InputWrongValueException;

public class GameController {

    public void run() {
        Cars cars = createCars();
        TryCount tryCount = createTryCount();

        printGameResult();
        RacingGame game = new RacingGame(tryCount, cars);
        game.racingStart();

        printVictory(new VictoryCars(cars));
    }

    private TryCount createTryCount() {
        printInputTryCount();
        return new TryCount(Console.readLine());
    }

    private Cars createCars() {
        while (true) {
            try {
                printInputCarName();
                Input<Cars> inputCarName = new InputCarName(Console.readLine());
                return inputCarName.create();
            } catch (InputWrongValueException error) {
                error.printMessage();
            }
        }
    }

}
