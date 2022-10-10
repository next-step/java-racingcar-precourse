package racingcar.domain;

public class Car {

    private final CarName carName;
    private final Movements movements;

    public Car(CarName carName) {
        this.carName = carName;
        this.movements = Movements.create();
    }

    public Movements getMovements() {
        return movements;
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.doMove()) {
            movements.add(MoveType.FORWARD);
            return;
        }
        movements.add(MoveType.STOP);
    }

    public CarName getName() {
        return carName;
    }

    public boolean isEqualForwardCount(MoveCount forwardCount) {
        return movements.getForwardCount().isEqualTo(forwardCount);
    }
}
