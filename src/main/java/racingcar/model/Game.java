package racingcar.model;

import java.util.List;

public class Game {

    private Cars cars;
    private Race race;

    public Game() {
    }

    public void init(List<String> carList, int raceCount) {
        cars = new Cars(carList);
        race = new Race(raceCount);
    }

    public void playGame(MovementCondition randomMovement) {
        race.raceStart();
        cars.moveResult(randomMovement);
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isFinished() {
        return race.isRaceFinish();
    }

    public List<String> result() {
        return race.raceResult(cars);
    }
}
