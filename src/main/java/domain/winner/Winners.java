package domain.winner;

import domain.history.CarHistories;
import domain.history.CarHistory;
import domain.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {
    private List<Winner> winners = new ArrayList<>();

    public Winners(CarHistories carHistories) {
        Position maxPosition = carHistories
                .getPositions()
                .getMaxPosition();

        for (CarHistory carHistory : carHistories.findByPosition(maxPosition)) {
            winners.add(new Winner(carHistory.getCarName()));
        }
    }

    public List<Winner> getWinners() {
        return new ArrayList<>(winners);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
