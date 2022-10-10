package racingcar;

import racingcar.domain.CarRace;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        CarRace carRace = loopInputCars();

        String tryCount = InputView.inputTryCount();
        carRace.inputTryCount(tryCount);

        ResultView.printResultStart();

        ResultView.printResult(carRace.racingGameStart());

        ResultView.printWinner(carRace.extractWinner());

    }

    private static CarRace loopInputCars() {
        while (true) {
            try {
                return createCars();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static CarRace createCars() {
        String carNameString = InputView.inputCarCount();
        return new CarRace(carNameString);
    }
}
