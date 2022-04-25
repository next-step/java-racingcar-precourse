package racingcar.domain;

public class RacingCar {
    public static final int VALUE_CAR_GO_FORWARD_CRITERION = 4;
    public static final int VALUE_CAR_GO_FORWARD_UNIT = 1;
    public static final int VALUE_CAR_INITIAL_POSITION = 0;

    private RacingCarName name;
    private int position;

    public RacingCar(String name) {
        this.name = new RacingCarName(name);
        this.position = VALUE_CAR_INITIAL_POSITION;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= VALUE_CAR_GO_FORWARD_CRITERION) {
            goForward();
        }
    }

    private void goForward() {
        position += VALUE_CAR_GO_FORWARD_UNIT;
    }
}
