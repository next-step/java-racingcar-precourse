package domain.history;

import domain.position.Position;
import domain.position.Positions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CarHistories {
    private List<CarHistory> carHistories;

    public CarHistories(List<CarHistory> carHistories) {
        this.carHistories = new ArrayList<>(carHistories);
    }

    public List<CarHistory> getCarHistories() {
        return Collections.unmodifiableList(carHistories);
    }

    public Positions getPositions() {
        List<Position> positions = new ArrayList<>();

        for (CarHistory carHistory : carHistories) {
            positions.add(carHistory.getPosition());
        }

        return new Positions(positions);
    }

    public List<CarHistory> findByPosition(Position comparePosition) {
        List<CarHistory> samePositionHistories = new ArrayList<>();

        for(CarHistory carHistory : carHistories) {
            addCarHistoryIfSamePosition(samePositionHistories, carHistory, comparePosition);
        }

        return samePositionHistories;
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

    private void addCarHistoryIfSamePosition(List<CarHistory> carHistories, CarHistory carHistory, Position comparePosition) {
        if (carHistory.getPosition().equals(comparePosition)) {
            carHistories.add(carHistory);
        }
    }
}
