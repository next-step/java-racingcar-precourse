package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.domain.factory.NextStepCarFactory;
import racingcar.view.GameMachine;

public class Application {

    public static void main(String[] args) {
        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();
    }


}
