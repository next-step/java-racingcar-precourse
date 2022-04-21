package racingcar.model.car;

import racingcar.model.racing.RacingStrategy;
import racingcar.model.record.CarRecord;
import racingcar.model.record.CarRecords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Entries {
    private final List<Car> cars;

    public Entries(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void race(RacingStrategy racingStrategy) {
        for (Car car : cars) {
            car.race(racingStrategy);
        }
    }

    public CarRecords convertCarRecords() {
        int maxPosition = getMaxPosition();

        List<CarRecord> carRecordList = new ArrayList<>();
        for (Car car : cars) {
            carRecordList.add(car.convertCarRecord(maxPosition));
        }

        return new CarRecords(carRecordList);
    }

    private int getMaxPosition() {
        Car maxPositionCar = Collections.max(cars);
        return maxPositionCar.getPosition();
    }
}
