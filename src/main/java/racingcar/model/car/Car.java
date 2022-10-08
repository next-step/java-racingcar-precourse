package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int VALUE_TO_ADVANCE = 4;
    private static final int INITIAL_POSITION = 0;
    private final Name name;
    private final Position position;
    private final List<Boolean> moveRecords;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INITIAL_POSITION);
        this.moveRecords = new ArrayList<>();
    }

    public void move(int value) {
        if (value >= VALUE_TO_ADVANCE) {
            position.go();
            moveRecords.add(true);
            return;
        }
        moveRecords.add(false);
    }

    public int getPosition() {
        return position.value();
    }

    public String getName() {
        return name.toString();
    }

    public List<Boolean> getMoveRecords() {
        return moveRecords;
    }

}
