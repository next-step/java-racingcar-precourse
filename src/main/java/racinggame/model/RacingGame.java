package racinggame.model;

public class RacingGame {
    public Cars play(Cars cars, int turnCnt) {
        System.out.println("실행 결과");

        GameTurns.run(cars, turnCnt);

        Cars winnerCars = cars.findFurthestCars();

        return winnerCars;
    }
}
