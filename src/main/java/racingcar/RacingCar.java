package racingcar;

public class RacingCar {

    public static final int MOVE_MINIMUM_VALUE = 4;

    private final Name name;
    private final TravelDistance distance;

    public RacingCar(String name) {
        this.name = new Name(name);
        this.distance = new TravelDistance();
    }

    public void moveForward(int random) {
        if(isMove(random))
            distance.increase();
    }

    public TravelDistance getTravelDistance() {
        return distance;
    }

    private boolean isMove(int random) {
        return random >= MOVE_MINIMUM_VALUE;
    }
}
