package racingcar.domain;

import racingcar.common.NaturalNumber;

import java.util.ArrayList;
import java.util.List;

public class RaceCars {

    private final List<Car> raceCars;

    private RaceCars(List<Car> cars) {
        this.raceCars = cars;
    }

    public static RaceCars of(List<Car> cars) {
        return new RaceCars(cars);
    }

    public NaturalNumber getCarCount() {
        return NaturalNumber.of(this.raceCars.size());
    }

    public void raceOneTime() {
        for (Car car : raceCars) {
            car.drive();
        }
    }
    
    public RaceResult getDriveRecords() {
        List<DriveRecord> driveRecords = new ArrayList<>();
        for (Car car : raceCars) {
            driveRecords.add(new DriveRecord(car.getCarName(), car.getCarPosition()));
        }
        return new RaceResult(driveRecords);
    }
}
