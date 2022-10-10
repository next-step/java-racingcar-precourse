package racingcar.domain;

public class RacingCar {
    public static final int MOVE_DISTANCE = 1;
    public static final int STOP_MAX_VALUE = 3;
    public static final int STARTING_POSITION = 0;
    public static final String MOVEMENT_DISPLAY_UNIT = "-";
    private final String name;
    private Integer position;

    private RacingCar(String name, Integer position) {
        this.name = name;
        this.position = position;
    }
    public static RacingCar getFromName(String name) throws IllegalArgumentException {
        return new RacingCar(name, STARTING_POSITION);
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getPositionString() {
        StringBuilder positionString = new StringBuilder();

        for (int i = 0; i < position; i++) {
            positionString.append(MOVEMENT_DISPLAY_UNIT);
        }

        return positionString.toString();
    }

    public void move(int i) throws IllegalArgumentException {
        if (i > STOP_MAX_VALUE) {
            position += MOVE_DISTANCE;
        }
    }

}
