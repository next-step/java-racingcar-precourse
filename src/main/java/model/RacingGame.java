package model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Round round;
    private final CarMoveRule carMoveRule;

    public RacingGame(Cars cars, Round round, CarMoveRule carMoveRule) {
        this.cars = cars;
        this.round = round;
        this.carMoveRule = carMoveRule;
    }

    public RaceResult race() {
        List<CarStates> raceResult = new ArrayList<>();
        while (round.isInProgress()) {
            CarStates carStates = cars.moveCars(carMoveRule);
            raceResult.add(carStates);
            round.finishOneRound();
        }
        return new RaceResult(raceResult);
    }
}