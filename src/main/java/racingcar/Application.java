package racingcar;

import racingcar.car.manager.Cars;
import racingcar.input.RacingPropertiesInput;
import racingcar.racing.Racing;
import racingcar.racing.RacingCarNames;
import racingcar.racing.RacingMoveCount;
import racingcar.racing.RacingProperties;
import racingcar.racing.WinnerCars;
import racingcar.ui.InputUi;
import racingcar.ui.ResultUi;

public class Application {
    public static void main(String[] args) {
        try {
            InputUi.requireCarNames();
            RacingCarNames racingCarNames = RacingPropertiesInput.requireCarNames();
            InputUi.requireTryCount();
            RacingMoveCount racingMoveCount = RacingPropertiesInput.requireMoveCount();

            RacingProperties properties = new RacingProperties(racingMoveCount, racingCarNames);
            Racing racing = new Racing(properties);
            while (!racing.isEnd()) {
                racing.tryMove();
                Cars cars = racing.cars();
                ResultUi.printCars(cars);
                System.out.println();
            }
            WinnerCars winner = racing.winner();
            ResultUi.winnerUi(winner);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }

    }
}
