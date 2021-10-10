package racinggame.domain;

public class Car {
    private final CarMovement carMovement;
    private int carGoCount;

    public Car() {
        carMovement = new CarMovement();
        carGoCount = 0;
    }

    public void move() {
        Movement movement = new Movement();
        addCarMovement(movement);
        addGoCount(movement);
    }

    private void addCarMovement(Movement movement) {
        carMovement.addCarMovement(movement.getMovementStatus());
    }

    private void addGoCount(Movement movement) {
        carGoCount += checkGoCount(movement.getMovementStatus());
    }

    private int checkGoCount(MovementStatus movementStatus) {
        if (movementStatus == MovementStatus.GO) {
            return 0;
        }
        return 1;
    }
}
