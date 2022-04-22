package racingcar;

import racingcar.controller.GameController;
import racingcar.model.racing.RacingStrategy;
import racingcar.model.racing.random.RandomRacingConfig;
import racingcar.model.racing.random.RandomRacingStrategy;
import racingcar.view.ConsoleGameInput;
import racingcar.view.ConsoleGameOutput;
import racingcar.view.GameInput;
import racingcar.view.GameOutput;

public class Application {
    public static void main(String[] args) {
        RacingStrategy racingStrategy = new RandomRacingStrategy(RandomRacingConfig.START_RANDOM_NUMBER,
                                                                 RandomRacingConfig.END_RANDOM_NUMBER,
                                                                 RandomRacingConfig.GREATER_THAN_OR_EQUAL_TO_STANDARD_NUMBER);
        GameInput input = new ConsoleGameInput();
        GameOutput output = new ConsoleGameOutput(System.out);

        GameController gameController = new GameController(racingStrategy, input, output);
        gameController.start();
    }
}
