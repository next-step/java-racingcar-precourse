package racingcar.game;

import racingcar.game.status.Exit;

public class GameController {
    public void start() {
        GameContext gameContext = new GameContext();
        while (!(gameContext.next() instanceof Exit)) {
        }
    }
}