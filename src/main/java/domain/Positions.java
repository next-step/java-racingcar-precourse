package domain;

import java.util.ArrayList;
import java.util.List;

public class Positions {
    private List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return new ArrayList<>(positions);
    }
}
