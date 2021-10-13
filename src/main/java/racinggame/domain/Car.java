package racinggame.domain;

public class Car {
    private final CarName carName;
    private final CarMovement carMovements;
    private GoCount goCount;

    public Car(CarName carName) {
        this.carName = carName;
        this.carMovements = new CarMovement();
        this.goCount = new GoCount();
    }

    public Car(CarName carName, CarMovement carMovement, GoCount goCount) {
        this.carName = carName;
        this.carMovements = carMovement;
        this.goCount = goCount;
    }

    public GoCount getGoCount() {
        return goCount;
    }

    public CarName getCarName() {
        return carName;
    }

    public CarMovement getCarMovements() {
        return carMovements;
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
        goCount.setGoCount(goCount.getGoCount() + checkGoCount(movement.getMovementStatus()));
    }

    private int checkGoCount(MovementStatus movementStatus) {
        if (movementStatus == MovementStatus.GO) {
            return 1;
        }
        return 0;
    }
}
