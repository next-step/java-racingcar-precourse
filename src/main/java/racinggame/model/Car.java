package racinggame.model;

import racinggame.model.enums.MoveAction;

public class Car {
    private static final int ZERO = 0;
    private static final char ROAD = '-';

    private final CarName name;
    private int position;
    private final StringBuilder road;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = ZERO;
        this.road = new StringBuilder();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public String getRoad() {
        return road.toString();
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
