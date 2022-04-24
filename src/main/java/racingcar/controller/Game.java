package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.view.GameView;
import racingcar.view.RoundCount;

public class Game {
    private final String PLAY_ROUND_MESSAGE = "실행 결과";
    private final GameView gameView;

    public Game(GameView gameView) {
        this.gameView = gameView;
    }

    public void play() {
        GameView gameView = new GameView();
        RacingCars racingCars = gameView.inputRacingCars();
        playRound(racingCars, gameView.inputRoundCount());
        gameView.printWinners(racingCars.getWinners());
    }

    private void playRound(RacingCars racingCars, RoundCount roundCount) {
        System.out.println(PLAY_ROUND_MESSAGE);
        for (int i = 0; i < roundCount.getRoundCount(); i++) {
            racingCars.playRound();
            gameView.printCarsPosition(racingCars.getCars());
        }
    }
}
