package racinggame.domain;

import java.util.ArrayList;

public class CarMovement {
    private final ArrayList<MovementStatus> carMovements;

    public CarMovement() {
        carMovements = new ArrayList<>();
    }

    public void addCarMovement(MovementStatus movementStatus) {
        carMovements.add(movementStatus);
    }
}
