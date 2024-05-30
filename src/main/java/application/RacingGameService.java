package application;

import domain.RacingGame;
import util.IOHandler;

public class RacingGameService {

    private final RacingGame racingGame = new RacingGame(new IOHandler());


    public void run() {
        racingGame.run();
    }

}
