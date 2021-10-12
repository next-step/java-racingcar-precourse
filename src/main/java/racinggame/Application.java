package racinggame;

import java.util.List;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        RacingCars racingCars = RacingGame.initRacingCars();
        int racingGameCount = RacingGame.initRacingGameCount();

        RacingGame racingGame = new RacingGame(racingCars, racingGameCount);
        racingGame.playRacingGame();
    }
}
