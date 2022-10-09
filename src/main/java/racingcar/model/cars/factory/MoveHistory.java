package racingcar.model.cars.factory;

import java.util.ArrayList;
import java.util.List;

public class MoveHistory {
    private final List<MoveEvent> moveEvents;

    public MoveHistory() {
        this.moveEvents = new ArrayList<>();
    }

    public void add(MoveEvent moveEvent) {
        moveEvents.add(moveEvent);
    }

    public List<MoveEvent> get() {
        List<MoveEvent> clones = new ArrayList<>();
        for (MoveEvent moveEvent : moveEvents) {
            clones.add(MoveEvent.of(moveEvent.get()));
        }
        return clones;
    }
}
