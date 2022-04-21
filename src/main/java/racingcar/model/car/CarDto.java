package racingcar.model.car;

import java.util.LinkedList;
import java.util.Queue;

public class CarDto {
    private final String name;
    private final Queue<Integer> positions;
    private final boolean champion;

    public CarDto(String name, Queue<Integer> positions, boolean champion) {
        this.name = name;
        this.positions = positions;
        this.champion = champion;
    }

    public String getName() {
        return name;
    }

    public Queue<Integer> getPositions() {
        return new LinkedList<>(positions);
    }

    public boolean isChampion() {
        return champion;
    }
}
