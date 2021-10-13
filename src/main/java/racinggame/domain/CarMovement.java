package racinggame.domain;

import java.util.ArrayList;

public class CarMovement {
    private final ArrayList<MovementStatus> carMovements;

    public CarMovement() {
        carMovements = new ArrayList<>();
    }

    public CarMovement(CarMovement carMovement) {
        carMovements = new ArrayList<>();
        for (MovementStatus movementStatus : carMovement.getCarMovements()) {
            carMovements.add(movementStatus);
        }
    }

    public ArrayList<MovementStatus> getCarMovements() {
        return carMovements;
    }

    public void addCarMovement(MovementStatus movementStatus) {
        carMovements.add(movementStatus);
    }
}
