package domain.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import domain.position.Position;
import domain.position.Positions;

public class CarHistories {
    private List<CarHistory> carHistories;

    public CarHistories(List<CarHistory> carHistories) {
        this.carHistories = new ArrayList<>(carHistories);
    }

    public List<CarHistory> getCarHistories() {
        return Collections.unmodifiableList(carHistories);
    }

    public List<CarHistory> getWinners() {
        return findByPosition(getPositions().getMaxPosition());
    }

    public Positions getPositions() {
        List<Position> positions = new ArrayList<>();

        for (CarHistory carHistory : carHistories) {
            positions.add(carHistory.getPosition());
        }

        return new Positions(positions);
    }

    @Override
    public boolean equals(Object dest) {
        if (this == dest) {
            return true;
        }
        if (dest == null || getClass() != dest.getClass()) {
            return false;
        }

        CarHistories that = (CarHistories) dest;
        return Objects.equals(carHistories, that.carHistories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carHistories);
    }

    private List<CarHistory> findByPosition(Position comparePosition) {
        List<CarHistory> samePositionHistories = new ArrayList<>();

        for (CarHistory carHistory : carHistories) {
            addCarHistoryIfSamePosition(samePositionHistories, carHistory, comparePosition);
        }

        return samePositionHistories;
    }

    private void addCarHistoryIfSamePosition(List<CarHistory> carHistories,
                                             CarHistory carHistory,
                                             Position comparePosition) {
        if (carHistory.getPosition().equals(comparePosition)) {
            carHistories.add(carHistory);
        }
    }
}
