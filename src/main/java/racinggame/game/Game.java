package racinggame.game;


import racinggame.game.car.CarNames;
import racinggame.game.car.Cars;
import racinggame.game.car.WinnerCarNames;
import racinggame.game.car.WinnerForwardMovementCount;
import racinggame.game.console.GameConsole;

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
