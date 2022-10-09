package racingcar.game;

import racingcar.model.function.Function;
import racingcar.model.function.ReadyToStart;

public class RacingGame {

    Function gameStart = new ReadyToStart();
    GameManager progress = new GameManager(gameStart);
    public void start(){
        while (progress.isPlay()) {
            progress.next();
        }
    }

}
