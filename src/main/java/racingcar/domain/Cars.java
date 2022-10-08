package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(CarNames carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(CarNames carNames) {
        List<Car> carList = new ArrayList<>();
        for (CarName carName : carNames.getList()) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public void move(MovableStrategy movableStrategy) {
        for (Car car : cars) {
            car.move(movableStrategy);
        }
    }

    public Winners findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        List<CarName> winnersName = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winnersName, car, maxPositionCar);
        }
        return new Winners(winnersName);
    }

    private void addWinner(List<CarName> winners, Car car, Car maxPositionCar) {
        if (car.isSamePosition(maxPositionCar)) {
            winners.add(car.getName());
        }
    }

    private Car findMaxPositionCar() {
        cars.sort(Comparator.reverseOrder());
        return cars.get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(String.format("%s\n", car.toString()));
        }
        return sb.toString();
    }
}
