package racingcar.model.record;

import java.util.ArrayList;
import java.util.List;

public class CarRecord {
    private final String name;
    private final List<Integer> positions;
    private final boolean champion;

    public CarRecord(String name, List<Integer> positions, boolean champion) {
        this.name = name;
        this.positions = new ArrayList<>(positions);
        this.champion = champion;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition(int index) {
        return positions.get(index);
    }

    public boolean isChampion() {
        return champion;
    }
}
