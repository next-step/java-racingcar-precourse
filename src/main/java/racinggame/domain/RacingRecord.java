package racinggame.domain;

public class RacingRecord {

    private final static String SEPARATOR = " : ";

    private final Car car;
    private final CarLocation recordLocation;

    private RacingRecord(Car car, CarLocation recordLocation) {
        this.car = car;
        this.recordLocation = recordLocation;
    }

    public static RacingRecord from(Car car) {
        return new RacingRecord(car, CarLocation.from(car.getLocation()));
    }

    @Override
    public String toString() {
        return car.getName().getValue() + SEPARATOR + recordLocation.toString();
    }
}
