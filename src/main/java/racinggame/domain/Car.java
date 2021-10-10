package racinggame.domain;

public class Car {
    private final CarMovement carMovement;

    public Car() {
        carMovement = new CarMovement();
    }

    public MovementStatus move(Movement movement) {
        addCarMovement(movement.getMovementStatus());
        return getLastCarMovement();
    }

    private void addCarMovement(MovementStatus movementStatus) {
        carMovement.addCarMovement(movementStatus);
    }

    private MovementStatus getLastCarMovement() {
        return carMovement.getLastCarMovement();
    }
}
