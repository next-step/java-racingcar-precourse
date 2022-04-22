package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.Times;

public class Game {
    private static final String TRY_MOVE_RUN_MESSAGE = "실행 결과";

    public void startGame() {
        Input<Cars> inputCarNames = new InputCarNames();
        Input<Times> inputTimes = new InputTimes();

        Cars cars = inputCarNames.input();

        raceCar(cars, inputTimes.input());

        System.out.println(cars.getRaceResult().getResult());
    }

    private void raceCar(Cars cars, Times times) {
        System.out.println(TRY_MOVE_RUN_MESSAGE);
        for (int i = 0; i < times.getTimes(); i++) {
            cars.tryMove();
        }
    }
}
