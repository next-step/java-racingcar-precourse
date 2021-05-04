package domain.winner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import domain.history.CarHistories;
import domain.history.CarHistory;

public class Winners {
    private List<Winner> winners = new ArrayList<>();

    public Winners(CarHistories carHistories) {
        for (CarHistory carHistory : carHistories.getWinners()) {
            winners.add(new Winner(carHistory.getCarName()));
        }
    }

    public List<Winner> getWinners() {
        return new ArrayList<>(winners);
    }

    @Override
    public boolean equals(Object dest) {
        if (this == dest) {
            return true;
        }
        if (dest == null || getClass() != dest.getClass()) {
            return false;
        }

        Winners winners1 = (Winners) dest;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
