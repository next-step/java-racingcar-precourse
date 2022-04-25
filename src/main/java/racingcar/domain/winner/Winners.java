package racingcar.domain.winner;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {

    private final List<Car> cars;
    private final List<String> winners;

    public Winners(List<Car> cars) {
        this.cars = cars;
        this.winners = new ArrayList<>();
        maxPositionCar();
    }

    public static Winners of(List<Car> cars) {
        return new Winners(cars);
    }

    private void maxPositionCar() {
        Car maxPositionCar = cars.get(0);
        for (int i = 0; i < cars.size() - 1; i++) {
            maxPositionCar = compareCar(maxPositionCar, cars.get(i));
        }
        addWinner(maxPositionCar);
    }

    private Car compareCar(Car maxPositionCar, Car car) {
        if (!maxPositionCar.comparePostion(car)) {
            maxPositionCar = car;
        }
        return maxPositionCar;
    }

    private void addWinner(Car maxPositionCar) {
        for (Car car : cars) {
            equalsCar(maxPositionCar, car);
        }
    }

    private void equalsCar(Car maxPositionCar, Car car) {
        if (maxPositionCar.equalsPosition(car)) {
            winners.add(car.getCarName());
        }
    }

    public String winners() {
        StringBuilder resultWinner = new StringBuilder();
        for (String winner : winners) {
            resultWinner.append(winner).append(",");
        }
        return resultWinner.toString().replaceFirst(".$", "");
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
