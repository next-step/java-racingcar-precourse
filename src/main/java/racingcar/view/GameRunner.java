package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ConstantMessage;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class GameRunner {

    RacingGame racingGame = new RacingGame();

    public void startGame() {
        Cars cars = inputCarNames();
        int trial = inputTrialCount();
        Cars resultCars = racingGame.attemptRacingCar(cars, trial);
        racingGame.drawCarMove(resultCars);
        racingGame.printWinnerCar(resultCars);
    }

    private Cars inputCarNames() {
        System.out.println(ConstantMessage.GAME_START_MESSAGE);
        Cars cars = racingGame.play(Console.readLine());
        return cars;
    }

    private int inputTrialCount() {
        System.out.println(ConstantMessage.GAME_TRIAL_COUNT);
        int trial = Integer.parseInt(Console.readLine());
        return trial;
    }
}
