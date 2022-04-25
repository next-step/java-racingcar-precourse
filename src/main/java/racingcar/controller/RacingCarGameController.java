package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Game;
import racingcar.model.RandomMovement;
import racingcar.utils.NumberValidator;
import racingcar.utils.StringValidator;
import racingcar.view.GameInput;
import racingcar.view.GameOutput;

public class RacingCarGameController {
    private final GameInput gameInput;
    private final GameOutput gameOutput;

    private static final String SPLIT_VALUE = ",";

    public RacingCarGameController(GameInput gameInput, GameOutput gameOutput) {
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
    }

    public void startGame() {
        Game game = new Game();
        play(game);
    }

    private void play(Game game) {
        game.init(inputCars(), inputCount());

        gameOutput.gameStart();
        while (!game.isFinished()) {
            game.playGame(new RandomMovement());
            gameOutput.printResult(game.getCars());
        }

        gameOutput.printWinner(game.result());
    }

    private List<String> inputCars() {
        String carList = "";

        do {
            carList = gameInput.inputCars();
        } while (!StringValidator.isValidCarInput(carList));

        return Arrays.asList(carList.split(SPLIT_VALUE));
    }

    private int inputCount() {
        String count = "";

        do {
            count = gameInput.inputCount();
        } while (!NumberValidator.isValidCountInput(count));

        return Integer.parseInt(count);
    }
}
