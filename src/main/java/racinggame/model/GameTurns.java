package racinggame.model;

import racinggame.enums.RANDOM_MOVE_RESULT;

import java.util.ArrayList;

public class GameTurns {
    public static ArrayList<ArrayList<RANDOM_MOVE_RESULT>> run(Cars cars, int turnCnt) {
        ArrayList<ArrayList<RANDOM_MOVE_RESULT>> result = new ArrayList<>();

        for (int i = 0; i < turnCnt; i++) {
            result.add(GameTurn.run(cars));
        }

        return result;
    }
}
