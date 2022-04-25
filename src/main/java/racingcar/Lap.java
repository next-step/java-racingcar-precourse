package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.RacingMessage.*;

public class Lap {

    private final Cars cars;

    public List<Car> getCarList() {
        return cars.getCars();
    }

    public Lap(Cars cars) {
        this.cars = cars;
    }

    public void start() {
        cars.race();
        cars.getCars().forEach(this::printLapResult);
        System.out.println();
    }

    public List<Car> getWinners() {
        return findWinners(getCarList());
    }

    private List<Car> findWinners(List<Car> cars) {
        Integer maxMileage = getMaxMileage(cars);
        return cars.stream()
                .filter(car -> car.getMileage() == maxMileage)
                .collect(Collectors.toList());
    }

    private Integer getMaxMileage(List<Car> cars) {
        return cars.stream()
                .map(Car::getMileage)
                .max(Comparator.comparing(x -> x))
                .get();
    }

    private void printLapResult(Car car) {
        StringBuilder sb = new StringBuilder(car.getName());
        sb.append(MESSAGE_SPACE).append(MESSAGE_COLON).append(MESSAGE_SPACE);
        for (int i = 0; i < car.getMileage(); i++) {
            sb.append(MESSAGE_LAP);
        }
        System.out.println(sb);
    }

}
