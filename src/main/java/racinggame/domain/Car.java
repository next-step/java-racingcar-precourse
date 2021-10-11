package racinggame.domain;

public class Car {
    private final CarName carName;
    private final CarMovement carMovement;
    private int carGoCount;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.carMovement = new CarMovement();
        this.carGoCount = 0;
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
