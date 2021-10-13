package racinggame.domain;

import racinggame.view.GameView;

public class RacingMain {

    private GameView gameView;
    private RacingGame racingGame;

    public void run() {
        // 레이싱 게임 생성
        gameView = new GameView();
        racingGame = new RacingGame(
                RacingGame.initCars(gameView.inputCars()),
                gameView.inputTryNo()
        );

        // 레이싱 반복
        while(racingGame.racing()) {
            racingGame.race();
            gameView.printCars(racingGame.getCars());
        }

        // 우승자 출력
        gameView.printWinners(racingGame.getWinners());
    }
}
