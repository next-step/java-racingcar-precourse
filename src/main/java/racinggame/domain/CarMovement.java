package racinggame.domain;

import java.util.ArrayList;

public class CarMovement {
    private final ArrayList<MovementStatus> carMovement;

    public CarMovement() {
        carMovement = new ArrayList<>();
    }

    public void addCarMovement(MovementStatus movementStatus) {
        carMovement.add(movementStatus);
    }

    public MovementStatus getLastCarMovement() {
        return carMovement.get(carMovement.size()-1);
    }
}
