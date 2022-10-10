package racingcar;

import racingcar.domain.Winners;
import racingcar.domain.playStrategy.RandomPlay;
import racingcar.dto.CarNames;
import racingcar.domain.RacingGame;
import racingcar.dto.TryTime;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        // input racingCar names and tryCount
        CarNames carNames = InputView.getCarNames();

        RacingGame racingGame = new RacingGame(carNames);
        TryTime tryTime = InputView.getTryTime();

        for (int i = 0; i < tryTime.getValue(); i++) {
            racingGame.go(new RandomPlay());

            // print racingCar move
            OutputView.printRacingGame(i, racingGame.getCarList());
        }

        // print winners
        OutputView.printWinners(Winners.getWinners(racingGame.getCarList()));
    }
}
