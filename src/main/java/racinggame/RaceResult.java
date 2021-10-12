package racinggame;

public class RaceResult {
    private final Cars cars;

    public RaceResult(Cars cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return Message.printRaceResult(cars);
    }

}
