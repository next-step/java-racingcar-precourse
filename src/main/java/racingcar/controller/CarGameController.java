package racingcar.controller;

import racingcar.domain.*;

public class CarGameController {

    private final MoveCondition moveCondition;

    public CarGameController(MoveCondition moveCondition) {
        this.moveCondition = moveCondition;
    }

    public CarGameResponse play(CarNames carNames, MoveCount moveCount) {
        Cars cars = new Cars(carNames);

        StringBuilder raceResult = play(cars, moveCount, new StringBuilder());

        CarNames winners = cars.getWinners();

        return new CarGameResponse(raceResult.toString(), winners.toString());
    }

    private StringBuilder play(Cars cars, MoveCount moveCount, StringBuilder moveResults) {
        if (!moveCount.isGreaterThan(new MoveCount(0))) {
            return moveResults;
        }

        cars.move(moveCondition);
        CarMovementsResults carsMovementResult = cars.getCarsMovementResult();
        moveResults.append(carsMovementResult.getResult());
        moveResults.append("\n");

        return play(cars, moveCount.decrease(), moveResults);
    }
}
