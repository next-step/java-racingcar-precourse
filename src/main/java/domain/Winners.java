package domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Winner> winners = new ArrayList<>();

    public Winners(Positions positions) {
        int maxPosition = positions.getMaxPosition();

        for (Position position : positions.getPositions()) {
            addPositionIfMax(position, maxPosition);
        }
    }

    private void addPositionIfMax(Position position, int maxPosition) {
        if(position.getPosition() == maxPosition) {
            winners.add(new Winner(position.getCarName()));
        }
    }

    public List<Winner> getWinners() {
        return new ArrayList<>(winners);
    }
}
