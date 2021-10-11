package racinggame.model;

public class RacingGame {
    public Cars play(Cars cars, int turnCnt) {
        GameTurns.run(cars, turnCnt);

        Cars winnerCars = cars.findFurthestCars();

        return winnerCars;
    }
}
