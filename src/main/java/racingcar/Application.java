package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {

        String carNames = InputView.inputCarName();
        int turn = InputView.inputTurn();

        Racing racing = new Racing(carNames);

        System.out.println("주행을 시작합니다.");

        for(int i = 0; i < turn; i++) {
            racing.race();
            OutputView.resultCar(racing.getRacingCars());
        }

        RacingResult result = new RacingResult(racing.getRacingCars());
        result.getMaxMoveCar();
        OutputView.getWinRacing(result);
    }
}
