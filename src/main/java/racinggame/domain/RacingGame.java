package racinggame.domain;

import java.util.ArrayList;

public class RacingGame {
    private final Cars cars;
    private int raceNum;
    private int maxGoCount;
    private ArrayList<Car> winners;

    public RacingGame(ArrayList<String> carNames, int raceNum) {
        this.cars = new Cars(carNames);
        this.raceNum = raceNum;
        setGameResult();
    }

    public int getMaxGoCount() {
        return maxGoCount;
    }

    public ArrayList<Car> getWinners() {
        return winners;
    }

    private void setMaxGoCount() {
        for (Car car : cars.getCars()) {
            maxGoCount = Math.max(maxGoCount, car.getGoCount());
        }
    }

    private void setAllRaceStates() {
        for (int raceIdx = 0; raceIdx < raceNum; raceIdx++) {
            goRace();
        }
    }

    public void setGameResult() {
        initializeGame();
        setAllRaceStates();
        setWinnerNames();
    }

    private void initializeGame() {
        maxGoCount = 0;
        winners = new ArrayList<>();
    }

    private void goRace() {
        cars.moveCars();
        setMaxGoCount();
    }

    private void setWinnerNames() {
        for (Car car : cars.getCars()) {
            addWinnerName(car);
        }
    }

    private void addWinnerName(Car car) {
        if (car.getGoCount() == maxGoCount) {
            winners.add(car);
        }
    }
}
