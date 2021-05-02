package racingcar;

public class RacingCar {

    public static final int MOVE_MINIMUM_VALUE = 4;

    private final Name name;
    private TravelDistance distance;

    public RacingCar(Name name) {
        this.name = name;
        this.distance = TravelDistance.create(0);
    }

    public void moveForward(int random) {
        if(isMove(random))
            this.distance = distance.increase();
    }

    public TravelDistance getTravelDistance() {
        return distance;
    }

    private boolean isMove(int random) {
        return random >= MOVE_MINIMUM_VALUE;
    }
}
