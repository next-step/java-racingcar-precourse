package racingcar.cars;

import racingcar.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Cars {

    public static final String CAR_NAME_SEPARATOR = ",";
    private static final String ERROR_MESSAGE = "'%s' 문자가 연속해서 입력될 수 없습니다.";
    private final List<Car> cars = new ArrayList<>();

    public Cars(final String input) {
        if (!ValidationUtils.validateSeparator(input)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, CAR_NAME_SEPARATOR));
        }
        for (final String name : input.split(CAR_NAME_SEPARATOR)) {
            this.cars.add(new Car(name));
        }
    }

    public Cars(final List<Car> list) {
        this.cars.addAll(list);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        Car winnerCar = this.getMaxDistanceCar();
        for (final Car currentCar : cars) {
            addWinner(winners, winnerCar, currentCar);
        }
        return winners;
    }

    private Car getMaxDistanceCar() {
        return Collections.max(cars);
    }

    private void addWinner(final List<Car> winners, final Car winnerCar, final Car currentCar) {
        if (winnerCar.getDistance() == currentCar.getDistance()) {
            winners.add(currentCar);
        }
    }
}
