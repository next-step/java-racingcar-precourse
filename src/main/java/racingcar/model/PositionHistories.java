package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class PositionHistories {

    private List<Integer> positionHistories;

    public PositionHistories() {
        this.positionHistories = new ArrayList<>();
    }

    public void add(Position position) {
        this.positionHistories.add(position.getPosition());
    }

    public List<Integer> getPositionHistories() {
        return positionHistories;
    }
}
