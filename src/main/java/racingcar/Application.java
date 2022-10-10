package racingcar;

import racingcar.application.CarRacingGame;
import racingcar.application.io.Input;
import racingcar.application.io.Output;
import racingcar.domain.policy.RandomNumber4MoreMovePolicy;

public class Application {
    public static void main(String[] args) {
        CarRacingGame game = new CarRacingGame(new Input(), new Output(), new RandomNumber4MoreMovePolicy());
        game.run();
    }
}
