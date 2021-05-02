package domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Winner> winners = new ArrayList<>();

    public Winners(CarHistories carHistories) {
        Position maxPosition = carHistories.getMaxPosition();

        for (CarHistory carHistory : carHistories.getCarHistories()) {
            addPositionIfMax(carHistory, maxPosition);
        }
    }

    private void addPositionIfMax(CarHistory carHistory, Position maxPosition) {
        if(carHistory.getPosition().equals(maxPosition)) {
            winners.add(new Winner(carHistory.getCarName()));
        }
    }

    public List<Winner> getWinners() {
        return new ArrayList<>(winners);
    }
}
