package racinggame.model;

public class RacingGame {
    private static final String GAME_RESULT_MSG_PREFIX = "실행 결과";

    public Cars play(Cars cars, int turnCnt) {
        System.out.println(GAME_RESULT_MSG_PREFIX);

        GameTurns.run(cars, turnCnt);

        Cars winnerCars = cars.findFurthestCars();

        return winnerCars;
    }
}
