package racingcar;

import racingcar.controller.GameController;
import racingcar.model.movement.MovementStrategy;
import racingcar.model.movement.random.RandomMovementConfig;
import racingcar.model.movement.random.RandomMovementStrategy;
import racingcar.view.ConsoleGameInput;
import racingcar.view.ConsoleGameOutput;
import racingcar.view.GameInput;
import racingcar.view.GameOutput;

public class Application {
    public static void main(String[] args) {
        MovementStrategy movementStrategy = new RandomMovementStrategy(RandomMovementConfig.START_RANDOM_NUMBER,
                                                                       RandomMovementConfig.END_RANDOM_NUMBER,
                                                                       RandomMovementConfig.GREATER_THAN_OR_EQUAL_TO_STANDARD_NUMBER);
        GameInput input = new ConsoleGameInput();
        GameOutput output = new ConsoleGameOutput(System.out);

        GameController gameController = new GameController(movementStrategy, input, output);
        gameController.start();
    }
}
