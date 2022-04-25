package racingcar;

import racingcar.view.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.getInstance();
        racingGame.playRacing();
    }
}
