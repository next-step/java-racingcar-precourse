package racingcar;

import racingcar.app.RacingCarGame;
import racingcar.io.DefaultInput;
import racingcar.io.DefaultOutput;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        Input input = new DefaultInput();
        Output output = new DefaultOutput();
        GameView gameView = new GameView(input, output);
        new RacingCarGame(gameView).play();
    }
}
