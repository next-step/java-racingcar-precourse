package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarHistories {
    private List<CarHistory> carHistories;

    public CarHistories(List<CarHistory> carHistories) {
        this.carHistories = carHistories;
    }

    public List<CarHistory> getCarHistories() {
        return new ArrayList<>(carHistories);
    }

    public Position getMaxPosition() {
        return Collections.max(getPositions(), Position::compareTo);
    }

    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();

        for(CarHistory carHistory : carHistories) {
            positions.add(carHistory.getPosition());
        }

        return positions;
    }
}
