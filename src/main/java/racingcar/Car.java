package racingcar;

import racingcar.util.ValidationUtil;

public class Car {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;
    private static final String NAME_DELIMITER = ",";
    private static final String DISTANCE_CHARACTER = "-";
    private static final String SPACE_CHARACTER = " ";
    private final String name;
    private final Engine engine;
    private int distance;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.distance = 0;
        this.engine = new Engine();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void goForward() {
        if (engine.isWorking()) {
            distance += 1;
        }
    }

    public String getCurrentResult() {
        return String.format("%s : %s", name, getDistanceCharacter());
    }

    private String getDistanceCharacter() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(DISTANCE_CHARACTER);
        }
        return sb.toString();
    }


    private void validate(String name) {
        ValidationUtil.validateNull(name);
        ValidationUtil.validateRestrictString(name, NAME_DELIMITER);
        ValidationUtil.validateRestrictString(name, SPACE_CHARACTER);
        ValidationUtil.validateLength(name, NAME_LENGTH_MIN, NAME_LENGTH_MAX);
    }

    public void goForwardAndPrint() {
        goForward();
        System.out.println(getCurrentResult());
    }
}
