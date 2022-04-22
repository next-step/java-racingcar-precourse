package racingcar.model.record;

import java.util.LinkedList;
import java.util.Queue;

public class CarRecord {
    private final String name;
    private final Queue<Integer> positions;
    private final boolean champion;

    public CarRecord(String name, Queue<Integer> positions, boolean champion) {
        this.name = name;
        this.positions = new LinkedList<>(positions);
        this.champion = champion;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return positions.poll();
    }

    public boolean isChampion() {
        return champion;
    }
}
