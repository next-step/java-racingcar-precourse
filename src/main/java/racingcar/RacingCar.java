package racingcar;

public class RacingCar {

    private static final int MIN_MOVE_FORWARD_RANDOM_VALUE = 4;

    private final Name name;
    private final TravelDistance travelDistance;

    public RacingCar(Name name) {
        this.name = name;
        this.travelDistance = new TravelDistance();
    }

    public void moveForward(int random) {
        if (isMoveForward(random))
            travelDistance.increase();
    }

    public String getName() {
        return this.name.getName();
    }

    public int getTravelDistance() {
        return this.travelDistance.getTravelDistance();
    }

    private boolean isMoveForward(int random) {
        return random >= MIN_MOVE_FORWARD_RANDOM_VALUE;
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
