package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.StandardMovingStrategy;
import racingcar.ui.StandardInput;
import racingcar.ui.StandardOutput;
import racingcar.ui.View;

public class Application {
    public static void main(String[] args) {
        View view = new View(new StandardInput(), new StandardOutput());
        RacingCarGame racingCarGame = new RacingCarGame(view, new RandomNumberGenerator(),
                new StandardMovingStrategy());

        racingCarGame.start();
    }
}
