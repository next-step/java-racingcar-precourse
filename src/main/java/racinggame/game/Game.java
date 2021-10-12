package racinggame.game;


import racinggame.game.console.GameConsole;
import racinggame.game.model.car.CarNames;
import racinggame.game.model.car.Cars;
import racinggame.game.model.car.WinnerCarNames;
import racinggame.game.model.car.WinnerForwardMovementCount;

public class Game {
    private final GameConsole gameConsole = new GameConsole();

    public void play() {
        CarNames carNames = gameConsole.getCarNames();
        Cars cars = new Cars(carNames.getCarNames());

        int tryCount = gameConsole.getTryCount();

        gameConsole.printRaceResultTitle();
        for (int i = 0; i < tryCount; i++) {
            cars.runRace();
            gameConsole.printRaceResult(cars.getCarList());
        }
        WinnerForwardMovementCount winnerForwardMovementCount = new WinnerForwardMovementCount(cars.getCarList());
        WinnerCarNames winnerCarNames
                = new WinnerCarNames(cars.getCarList(), winnerForwardMovementCount.getWinnerForwardMovementCount());

        gameConsole.printRaceWinners(winnerCarNames.getWinnerCarNames());
    }
}
