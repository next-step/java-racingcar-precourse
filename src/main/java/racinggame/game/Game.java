package racinggame.game;


import racinggame.game.car.Car;
import racinggame.game.console.GameConsole;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final GameConsole gameConsole = new GameConsole();
    private List<Car> cars = new ArrayList<>();

    public void play() {

        List<String> carNames = gameConsole.getCarNames();
        setCars(carNames);

        int tryCount = gameConsole.getTryCount();

        gameConsole.printRaceResultTitle();
        for (int i = 0; i < tryCount; i++) {
            runRace();
            gameConsole.printRaceResult(cars);
        }

    }


    private void setCars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    private void runRace() {
        for (Car car : cars) {
            car.runRace();
        }
    }
}
