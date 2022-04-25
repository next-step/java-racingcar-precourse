package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.RacingGame;
import racingcar.ui.UiService;

import java.util.ArrayList;
import java.util.List;

public class RacingCarApplication {

    private final UiService uiService = new UiService();

    public void start() {
        RacingGame racingGame = initRacingGame();
        int moveTimes = getMoveTimes();

        uiService.printMoveStart();
        for (int i = 0; i < moveTimes; i++) {
            racingGame.move();
            uiService.printPosition(racingGame.printCurrentPosition());
        }

        uiService.printWinners(racingGame.findWinners());
    }

    private RacingGame initRacingGame() {
        return new RacingGame(createCar());
    }

    private Cars createCar() {
        uiService.printNameInput();
        try {
            return createCar(uiService.readNames());
        } catch (IllegalArgumentException e) {
            uiService.printErrorMessage(e.getMessage());
        }
        return createCar();
    }

    private Cars createCar(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(new Name(name), new Position()));
        }
        return new Cars(cars);
    }

    private int getMoveTimes() {
        try {
            uiService.printMoveTimesInput();
            return uiService.readMoveTimes();
        } catch (NumberFormatException e) {
            uiService.printErrorMessage("시도 횟수는 숫자여야 한다.");
        }
        return getMoveTimes();
    }
}
