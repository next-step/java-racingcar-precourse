package racingcar.model.car;

import racingcar.model.racing.RacingStatus;

import java.util.LinkedList;
import java.util.Queue;

public class CarPosition {
    private final Queue<Integer> positions;
    private int position;

    public CarPosition() {
        this.positions = new LinkedList<>();
        this.position = 0;
    }

    public void recordPosition(RacingStatus racingStatus) {
        if (racingStatus.isGo()) {
            increasePosition();
        }
        positions.offer(position);
    }

    private void increasePosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public Queue<Integer> getPositions() {
        return new LinkedList<>(positions);
    }
}
