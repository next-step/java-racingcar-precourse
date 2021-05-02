package racingcar;

public class RacingCar {

    private final Name name;
    private TravelDistance distance;

    public RacingCar(Name name) {
        this.name = name;
        this.distance = TravelDistance.ZERO;
    }

    public void moveForward(int random) {
        if(random >= 4)
            this.distance = distance.increase();
    }

    public TravelDistance getTravelDistance() {
        return distance;
    }
}
