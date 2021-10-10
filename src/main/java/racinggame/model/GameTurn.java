package racinggame.model;

import racinggame.enums.RANDOM_MOVE_RESULT;

import java.util.ArrayList;

public class GameTurn {
    private CarMover carMover;

    public GameTurn() {
        this.carMover = new CarMover();
    }

    public ArrayList<RANDOM_MOVE_RESULT> run(ArrayList<Car> cars) {
        ArrayList<RANDOM_MOVE_RESULT> result = new ArrayList<>();

        for (Car car : cars) {
            result.add(this.carMover.moveRandomizly(car));
        }

        return result;
    }
}
