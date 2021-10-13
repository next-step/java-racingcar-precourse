package racinggame.domain;

import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingMain {

    private RacingGame racingGame;
    private InputView inputView = new InputView();;
    private ResultView resultView = new ResultView();;

    public void run() {
        // 레이싱 게임 생성
        racingGame = new RacingGame(
                RacingGame.initCars(inputView.getCars()),
                inputView.getTryNo()
        );

        // 레이싱 반복
        while(racingGame.racing()) {
            racingGame.race();
            resultView.printCars(racingGame.getCars());
        }

        // 우승자 출력
        resultView.printWinners(racingGame.getWinners());
    }
}
