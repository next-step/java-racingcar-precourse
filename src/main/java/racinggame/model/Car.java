package racinggame.model;

import racinggame.model.enums.MoveAction;

public class Car {
    private static final int ZERO = 0;
    private static final char ROAD = '-';

    private final CarName name;
    private final StringBuilder road;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.road = new StringBuilder();
        this.position = ZERO;
    }

    public String getName() {
        return name.getName();
    }

    public String getRoad() {
        return road.toString();
    }

    public int getPosition() {
        return position;
    }

    public void move(MoveCondition condition) {
        MoveAction action = condition.judge();

        if (action.isGo()) {
            go();
        }
    }

    private void go() {
        position++;
        road.append(ROAD);
    }
}
