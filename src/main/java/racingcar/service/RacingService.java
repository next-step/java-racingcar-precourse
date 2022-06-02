package racingcar.service;

import racingcar.domain.MovingCheck;
import racingcar.domain.RacingCarMovingCheck;
import racingcar.domain.RacingGame;
import racingcar.utils.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingService {

    private String[] carNames;
    private int gameNum;

    public void init() {
        ResultView.print("경주할 자동차 이름(이름은 쉼표(,)를 기준으로 구분)");
        this.carNames = InputView.splitCarName();

        ResultView.print("시도할 회수");
        this.gameNum = InputView.gameNum();
    }

    public void play() {
        RacingGame racingGame = new RacingGame();
        RacingCarMovingCheck racingCarMovingCheck = new RacingCarMovingCheck(new RandomNumber());

        ResultView.print("실행 결과");
        for(int i = 0; i < gameNum; i++) {
            playGame(racingGame, racingCarMovingCheck);
            ResultView.winnerNameView(racingGame.getWinnerList());
        }
    }

    public void playGame(RacingGame racingGame, MovingCheck movingCheck) {
        racingGame.setUpRacingCar(carNames);
        racingGame.carMoving(movingCheck, carNames);
    }
}
