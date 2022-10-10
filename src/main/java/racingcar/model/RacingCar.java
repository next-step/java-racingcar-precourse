package racingcar.model;

public class RacingCar {
    private final CarName carName;
    private final Lap currentLap;
    private final MoveRecords moveRecords;
    private final MoveStrategy moveStrategy;

    public RacingCar(CarName carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.currentLap = new Lap(0);
        this.moveRecords = new MoveRecords();
        this.moveStrategy = moveStrategy;
    }

    public RacingCar(CarName carName, Lap lap, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.currentLap = lap;
        this.moveRecords = new MoveRecords();
        this.moveStrategy = moveStrategy;
    }

    public void raceOneLap() {
        boolean canMove = moveStrategy.canMove();
        if (canMove) {
            currentLap.increment();
        }
        moveRecords.addRecord(new MoveRecord(canMove));
    }

    public CarName getCarName() {
        return carName;
    }

    public MoveRecords getMoveRecords() {
        return moveRecords;
    }

    public Lap getCurrentLap() {
        return currentLap;
    }
}
