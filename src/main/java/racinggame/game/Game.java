package racinggame.game;


import racinggame.game.car.Car;
import racinggame.game.console.GameConsole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final GameConsole gameConsole = new GameConsole();
    private List<Car> cars = new ArrayList<>();

    private List<String> winnerCarNames = null;
    private int winnerForwardMovementCount = 0;

    public void play() {
        List<String> carNames = gameConsole.getCarNames();
        setCars(carNames);

        int tryCount = gameConsole.getTryCount();

        gameConsole.printRaceResultTitle();
        for (int i = 0; i < tryCount; i++) {
            runRace();
            gameConsole.printRaceResult(cars);
        }
        setWinnerCarNames();
        gameConsole.printRaceWinners(getWinnerCarNames());
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


    private void setWinnerCarNames() {
        this.winnerCarNames = new ArrayList<>();
        this.winnerForwardMovementCount = Collections.max(cars).getForwardMovementCount();
        Collections.reverse(cars);

        for (Car car : cars) {
            addNamesIfIsWinner(car);
        }
    }

    private void addNamesIfIsWinner(Car car) {
        if(car.getForwardMovementCount() == this.winnerForwardMovementCount) {
            this.winnerCarNames.add(car.getName());
        }
    }

    private List<String> getWinnerCarNames() {
        return winnerCarNames;
    }
}
