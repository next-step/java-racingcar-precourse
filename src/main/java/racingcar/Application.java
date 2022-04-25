package racingcar;

import static java.lang.System.out;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarsFactory;
import racingcar.domain.RacingGame;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(getCars(), getRound());
        while (racingGame.isRacing()) {
            racingGame.race();
            ResultView.print(racingGame.getCars());
        }
        ResultView.printWinner(racingGame.getWinners());
    }

    private static List<Car> getCars() {
        try {
            return CarsFactory.of(InputView.getCarNames());
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
            return getCars();
        }
    }

    private static Round getRound() {
        try {
            return new Round(InputView.getRounds());
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
            return getRound();
        }
    }
}
