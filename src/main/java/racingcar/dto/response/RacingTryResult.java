package racingcar.dto.response;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.racing.car.Cars;
import racingcar.dto.response.car.Car;

public class RacingTryResult {
    private final List<Car> carList;

    private RacingTryResult(List<Car> carList) {
        this.carList = carList;
    }

    public static RacingTryResult from(Cars cars) {
        List<Car> carList = new ArrayList<>();
        cars.getCarList().forEach(car -> carList.add(Car.of(car.getName(), car.getLocation())));
        return new RacingTryResult(carList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        carList.forEach(car -> stringBuilder.append(car.toString() + "\n"));
        return stringBuilder.toString();
    }
}
