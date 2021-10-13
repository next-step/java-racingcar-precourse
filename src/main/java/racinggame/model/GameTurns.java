package racinggame.model;

import racinggame.vo.GameTurnCnt;

public class GameTurns {
    public static GameTurnResults run(Cars cars, GameTurnCnt turnCnt) {
        GameTurnResults result = new GameTurnResults();

        for (int i = 0; i < turnCnt.get(); i++) {
            result.add(GameTurn.run(cars));

            System.out.println(cars.toString());
        }

        return result;
    }
}
