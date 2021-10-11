package racinggame.model;

public class GameTurns {
    public static GameTurnResults run(Cars cars, int turnCnt) {
        GameTurnResults result = new GameTurnResults();

        for (int i = 0; i < turnCnt; i++) {
            result.add(GameTurn.run(cars));

            System.out.println(cars.toString());
        }

        return result;
    }
}
