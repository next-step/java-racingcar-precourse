package racinggame.game;


import racinggame.game.car.Cars;
import racinggame.game.console.GameConsole;

import java.util.List;

public class Game {
    private final GameConsole gameConsole = new GameConsole();

    public void play() {
        List<String> carNames = gameConsole.getCarNames();
        Cars cars = new Cars(carNames);

        int tryCount = gameConsole.getTryCount();

        gameConsole.printRaceResultTitle();
        for (int i = 0; i < tryCount; i++) {
            cars.runRace();
            gameConsole.printRaceResult(cars.getCarList());
        }
        gameConsole.printRaceWinners(cars.getWinnerCarNames());
    }
}
