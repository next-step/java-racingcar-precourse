package racingcar.model.car;

import racingcar.dto.CarRecordDto;
import racingcar.model.movement.MovementStrategy;

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

    public List<CarRecordDto> convertCarRecords() {
        int maxPosition = getMaxPosition();

        List<CarRecordDto> carRecordList = new ArrayList<>();
        for (Car car : cars) {
            carRecordList.add(car.convertCarRecord(maxPosition));
        }

        return Collections.unmodifiableList(carRecordList);
    }

    private int getMaxPosition() {
        Car maxPositionCar = Collections.max(cars);
        return maxPositionCar.getPosition();
    }
}
