package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.PositiveNumber;

public final class Game {

    private final Cars cars;
    private final PositiveNumber maxPlayCount;
    private PositiveNumber currentPlayCount;

    public Game(final Cars cars, final PositiveNumber maxPlayCount) {
        this.cars = cars;
        this.maxPlayCount = maxPlayCount;
        this.currentPlayCount = PositiveNumber.ONE;
    }

    private static List<CarStatusDto> mapToCarStatuses(final List<Car> cars) {
        final List<CarStatusDto> result = new ArrayList<>(cars.size());
        for (final Car car : cars) {
            result.add(new CarStatusDto(car.getName(), car.getDistance()));
        }
        return result;
    }

    private static List<String> mapToCarNames(final List<Car> cars) {
        final List<String> result = new ArrayList<>(cars.size());
        for (final Car car : cars) {
            result.add(car.getName());
        }
        return result;
    }

    public void play() {
        if (isGameOver()) {
            return;
        }
        cars.move();
        increasePlayCount();
    }

    private void increasePlayCount() {
        currentPlayCount = currentPlayCount.plus(PositiveNumber.ONE);
    }

    public boolean isGameOver() {
        return currentPlayCount.isGreaterThan(maxPlayCount);
    }

    public List<CarStatusDto> getCarsStatus() {
        return mapToCarStatuses(cars.getCars());
    }

    public List<String> getWinners() {
        return mapToCarNames(cars.getFarthestMovedCars());
    }

}
