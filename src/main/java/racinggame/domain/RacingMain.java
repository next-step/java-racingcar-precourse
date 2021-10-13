package racinggame.domain;

import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingMain {

    private InputView inputView;
    private ResultView resultView;
    private RacingGame racingGame;

    public void run() {
        // 레이싱 게임 생성
        inputView = new InputView();
        racingGame = new RacingGame(
                RacingGame.initCars(inputView.inputCars()),
                inputView.inputTryNo()
        );

        resultView = new ResultView();
        // 레이싱 반복
        while(racingGame.racing()) {
            racingGame.race();
            resultView.printCars(racingGame.getCars());
        }

        // 우승자 출력
        resultView.printWinners(racingGame.getWinners());
    }
}
