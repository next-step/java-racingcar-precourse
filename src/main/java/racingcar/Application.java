package racingcar;

import racingcar.game.RacingGameMachine;

public class Application {
    public static void main(String[] args) {
        RacingGameMachine.init()
                .start();
    }
}
