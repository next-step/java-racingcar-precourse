package racinggame.domain;

public class Car {
    private final CarName carName;
    private final CarMovement carMovements;
    private int goCount;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.carMovements = new CarMovement();
        this.goCount = 0;
    }

    public int getGoCount() {
        return goCount;
    }

    public void move() {
        Movement movement = new Movement();
        addCarMovement(movement);
        addGoCount(movement);
    }

    private void addCarMovement(Movement movement) {
        carMovements.addCarMovement(movement.getMovementStatus());
    }

    private void addGoCount(Movement movement) {
        goCount += checkGoCount(movement.getMovementStatus());
    }

    private int checkGoCount(MovementStatus movementStatus) {
        if (movementStatus == MovementStatus.GO) {
            return 0;
        }
        return 1;
    }
}

