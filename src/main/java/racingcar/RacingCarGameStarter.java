package racingcar;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.io.GameConsolePrinter;
import racingcar.io.GameMissionUtilsScanner;
import racingcar.io.GamePrinter;
import racingcar.io.GameScanner;

import java.util.List;

public class RacingCarGameStarter {
    private final GamePrinter gamePrinter = new GameConsolePrinter();
    private final GameScanner gameScanner = new GameMissionUtilsScanner();

    public void start() {
        Cars cars = initCars();
        int round = initRound();
        runRacing(cars, round);
        result(cars);
    }

    private Cars initCars() {
        gamePrinter.printCarNameInfo();
        List<String> carNameList = gameScanner.scanCarNames();
        Cars cars = new Cars();
        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int initRound() {
        gamePrinter.printCountInfo();
        return gameScanner.scanCount();
    }

    private void runRacing(Cars cars, int round) {
        System.out.println();
        gamePrinter.printRoundResultPrefix();
        for (int i = 0; i < round; i++) {
            cars.move();
            gamePrinter.printRoundResult(cars);
        }
    }

    private void result(Cars cars) {
        gamePrinter.printWinner(cars.calcWinner());
    }
}
