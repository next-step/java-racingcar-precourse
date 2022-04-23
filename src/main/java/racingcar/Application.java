package racingcar;

import racingcar.model.Car;
import racingcar.model.Move;
import racingcar.model.RacingCars;
import racingcar.utils.CarGeneratorUtils;
import racingcar.view.GameView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = getRacingGame();
        GameView.printStartMessage();

        do {
            racingGame.start();
        } while (racingGame.ableToPlay());

        racingGame.outputFinalResult();
    }

    private static RacingGame getRacingGame() {
        final List<Car> cars = getCarNamesReEnterIfIllegalArgumentException();
        final RacingCars racingCars = new RacingCars(cars);
        final Move move = getMoveReEnterIfIllegalArgumentException();
        return new RacingGame(racingCars, move);
    }

    private static List<Car> getCarNamesReEnterIfIllegalArgumentException() {
        try {
            GameView.printEnterCarNames();
            final String carNames = GameView.enterMessage();
            return CarGeneratorUtils.getCars(carNames);
        } catch (IllegalArgumentException e) {
            GameView.printMessage(e.getMessage());
            return getCarNamesReEnterIfIllegalArgumentException();
        }
    }

    private static Move getMoveReEnterIfIllegalArgumentException() {
        try {
            GameView.printEnterTryNumber();
            final String moves = GameView.enterMessage();
            return new Move(moves);
        } catch (IllegalArgumentException e) {
            GameView.printMessage(e.getMessage());
            return getMoveReEnterIfIllegalArgumentException();
        }
    }

}
