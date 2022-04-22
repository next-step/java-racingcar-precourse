package racingcar.model.car;

import racingcar.model.movement.MovementStrategy;
import racingcar.model.record.CarRecord;
import racingcar.model.record.CarRecords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarEntries {
    private final List<Car> cars;

    public CarEntries(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void race(MovementStrategy movementStrategy) {
        for (Car car : cars) {
            car.race(movementStrategy);
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
