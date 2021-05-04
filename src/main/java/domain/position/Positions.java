package domain.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Positions {
    private List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = new ArrayList<>(positions);
    }

    public Position getMaxPosition() {
        return Collections.max(positions, Position::compareTo);
    }

    public List<Position> getPositions() {
        return Collections.unmodifiableList(positions);
    }

    @Override
    public boolean equals(Object dest) {
        if (this == dest) {
            return true;
        }
        if (dest == null || getClass() != dest.getClass()) {
            return false;
        }

        Positions positions1 = (Positions) dest;
        return Objects.equals(positions, positions1.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
