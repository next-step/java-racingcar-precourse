package domain.history;

import domain.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarHistories that = (CarHistories) o;
        return Objects.equals(carHistories, that.carHistories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carHistories);
    }
}
