package racingcar.domain;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movements {

    private final List<MoveType> movements;

    public Movements(List<MoveType> movements) {
        this.movements = movements;
    }

    public Movements(MoveType ...moveTypes) {
        this(Lists.newArrayList(moveTypes));
    }

    public static Movements create() {
        return new Movements(new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movements movements1 = (Movements) o;

        return movements.equals(movements1.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movements);
    }

    public void add(MoveType moveType) {
        movements.add(moveType);
    }

    public List<MoveType> getList() {
        return movements;
    }

    public MoveCount getForwardCount() {
        int forwardCount = 0;
        for (MoveType movement : movements) {
            forwardCount += (movement == MoveType.FORWARD) ? 1 : 0;
        }
        return new MoveCount(forwardCount);
    }

}
