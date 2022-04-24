package racingcar;

import racingcar.controller.RacingGame;
import racingcar.model.GameResult;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        GameResult result = game.start();
        ResultView.printWinner(result);
    }
}
