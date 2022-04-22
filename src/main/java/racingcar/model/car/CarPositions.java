package racingcar.model.car;

import racingcar.model.movement.MovementStatus;

import java.util.ArrayList;
import java.util.List;

public class CarPositions {
    private final List<Integer> positions;

    public CarPositions() {
        this.positions = new ArrayList<>();
    }

    public void recordPosition(MovementStatus movementStatus) {
        int position = getPosition();
        if (movementStatus.isGo()) {
            position++;
        }
        positions.add(position);
    }

    public int getPosition() {
        if (positions.isEmpty()) {
            return 0;
        }
        return positions.get(positions.size() - 1);
    }

    public List<Integer> getPositions() {
        return new ArrayList<>(positions);
    }
}
