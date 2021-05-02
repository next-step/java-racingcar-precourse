package racingcar;

public class RacingCar {

    public static final int MOVE_MINIMUM_VALUE = 4;

    private final Name name;
    private final TravelDistance distance;

    public RacingCar(Name name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacingCar racingCar = (RacingCar) o;

        return name.equals(racingCar.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
