package racingcar;

import racingcar.controller.Game;
import racingcar.model.progress.MinGoScoreInclusive;

public class Application {
    public static void main(String[] args) {
        MinGoScoreInclusive minGoScoreInclusive = new MinGoScoreInclusive(4);
        Game game = new Game(minGoScoreInclusive);
        game.start();
    }
}
