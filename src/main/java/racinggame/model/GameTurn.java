package racinggame.model;

public class GameTurn {
    private CarMover carMover;

    public GameTurn() {
        this.carMover = new CarMover();
    }

    public static GameTurnResult run(Cars cars) {
        GameTurnResult result = new GameTurnResult();

        for (Car car : cars) {
            result.add(CarMover.moveRandomizly(car));
        }

        return result;
    }
}
