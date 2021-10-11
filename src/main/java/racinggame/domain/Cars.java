package racinggame.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars move() {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            car.changePosition();
            movedCars.add(car);
        }
        return new Cars(movedCars);
    }

    public Map<String, String> getCarsStatus() {
        Map<String, String> statusMap = new HashMap<>();
        for (Car car : cars) {
            statusMap.put(car.getName(), car.getPosition().convertToHyphen());
        }
        return statusMap;
    }

    public Position getMaxPosition() {
        Position maxCarPosition = new Position();

        for (Car car : cars) {
            maxCarPosition = findMaxPosition(maxCarPosition, car.getPosition());
        }

        return maxCarPosition;
    }

    public Cars winners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(winners, car, maxPosition);
        }

        return new Cars(winners);
    }

    private void addWinner(List<Car> winners, Car car, Position maxPosition) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }

    private Position findMaxPosition(Position maxPosition, Position carPosition) {
        if (maxPosition.getValue() < carPosition.getValue()) {
            return carPosition;
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
