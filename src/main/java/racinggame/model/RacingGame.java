package racinggame.model;

import racinggame.vo.GameTurnCnt;

public class RacingGame {
    private static final String GAME_RESULT_MSG_PREFIX = "실행 결과";

    public Cars play(Cars cars, GameTurnCnt turnCnt) {
        System.out.println(GAME_RESULT_MSG_PREFIX);

        this.runTurns(cars, turnCnt);

        Cars winnerCars = cars.findFurthestCars();

        return winnerCars;
    }

    private void runTurns(Cars cars, GameTurnCnt turnCnt) {
        for (int i = 0; i < turnCnt.get(); i++) {
            this.runOneTurn(cars);

            System.out.println(cars.toString());
        }
    }

    private void runOneTurn(Cars cars) {
        for (Car car : cars) {
            CarMover.moveRandomizly(car);
        }
    }
}
