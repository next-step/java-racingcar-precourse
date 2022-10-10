package racingcar;

import racingcar.model.Cars;
import racingcar.model.PositiveNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        final Cars cars = getValidCarsFromInput();
        final PositiveNumber playCount = getValidPlayCountFromInput();

        OutputView.printDivider();
        OutputView.printGameResultTitle();
        final Game game = new Game(cars, playCount);
        while (!game.isGameOver()) {
            game.play();
            OutputView.printCarsStatus(game.getCarsStatus());
            OutputView.printDivider();
        }
        OutputView.printWinners(game.getWinners());
    }

    private static Cars getValidCarsFromInput() {
        Cars cars = null;
        while (cars == null) {
            cars = createCarsFromInput();
        }
        return cars;
    }

    private static Cars createCarsFromInput() {
        final String carNames = InputView.getCarNames();
        try {
            return CarFactory.getDefaultCars(carNames);
        } catch (final IllegalArgumentException exception) {
            OutputView.printException(exception);
            return null;
        }
    }

    private static PositiveNumber getValidPlayCountFromInput() {
        PositiveNumber positiveNumber = null;
        while (positiveNumber == null) {
            positiveNumber = createPositiveNumberFromInput();
        }
        return positiveNumber;
    }

    private static PositiveNumber createPositiveNumberFromInput() {
        final String playCount = InputView.getPlayCount();
        try {
            return new PositiveNumber(playCount);
        } catch (final IllegalArgumentException exception) {
            OutputView.printException(exception);
            return null;
        }
    }
}
