package domain.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Positions {
    private List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public Position getMaxPosition() {
        return Collections.max(positions, Position::compareTo);
    }

    public List<Position> getPositions() {
        return new ArrayList<>(positions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positions positions1 = (Positions) o;
        return Objects.equals(positions, positions1.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
