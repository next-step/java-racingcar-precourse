package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Positions {
    private List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return new ArrayList<>(positions);
    }

    public int getMaxPosition() {
        return Collections.max(positions, Comparator.comparingInt(Position::getPosition)).getPosition();
    }
}
