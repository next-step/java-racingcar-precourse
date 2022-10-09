package racingcar.car;

import racingcar.move.Movement;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void calculatePosition(Movement move) {
        if (move.isMoveAble()) {
            this.position = move.getIncreasePosition(this.position);
        }
    }
}
