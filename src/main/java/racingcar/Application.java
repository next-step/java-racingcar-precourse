package racingcar;

import org.junit.platform.commons.function.Try;
import racingcar.model.Cars;
import racingcar.model.CarsFactory;
import racingcar.model.RacingGame;
import racingcar.model.TryCount;
import racingcar.model.exception.NullOrBlankException;
import racingcar.model.exception.OverMaxNameLengthException;
import racingcar.model.exception.OverTryCountException;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(getCarNames(), getTryCount());

        ResultView.printResultMessage();
        while (racingGame.isRacing()) {
            racingGame.race();
            ResultView.printCarsPosition(racingGame.getCarsStatus());
        }
        ResultView.printWinnerCars(racingGame.getWinnerCars());
    }

    private static Cars getCarNames() {
        Cars cars = null;
        while (cars == null) {
            try {
                cars = CarsFactory.create(InputView.getCarNames());
            } catch (OverMaxNameLengthException | NullOrBlankException e) {
                ResultView.printError(e.getMessage());
            }
        }
        return cars;
    }

    private static TryCount getTryCount() {
        TryCount tryCount = null;
        while (tryCount == null) {
            try {
                tryCount = new TryCount(InputView.getTryCount());
            } catch (NumberFormatException e) {
                ResultView.printError(e.getMessage());
            }
        }
        return tryCount;
    }
}
