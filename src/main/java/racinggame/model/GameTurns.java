package racinggame.model;

import java.util.ArrayList;

public class GameTurns {
    public static ArrayList<GameTurnResult> run(Cars cars, int turnCnt) {
        ArrayList<GameTurnResult> result = new ArrayList<>();

        for (int i = 0; i < turnCnt; i++) {
            result.add(GameTurn.run(cars));
        }

        return result;
    }
}
