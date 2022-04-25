package racingcar;

public class PositionOfHead {

    private int positionOfHead;

    public PositionOfHead() {
        this.positionOfHead = 0;
    }

    public void setPositionIfNewHead(Car car) {
        if (isThisCarNewHead(car)) {
            positionOfHead = car.getPosition();
        }
    }

    private boolean isThisCarNewHead(Car car) {
        return car.getPosition() > positionOfHead;
    }

    public boolean isHead(Car car) {
        return car.getPosition() == positionOfHead;
    }

    public int get() {
        return positionOfHead;
    }
}
