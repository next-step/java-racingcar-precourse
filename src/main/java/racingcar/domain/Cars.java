package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinnerCars(){
        Position maxPosition = findMaxPosition();

        return findCarsByMaxPosition(maxPosition);
    }

    private List<Car> findCarsByMaxPosition(Position maxPosition) {
        List<Car> findCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.isWinner(maxPosition)){
                findCars.add(car);
            }
        }

        return findCars;
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position();

        for (Car car : this.cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        return maxPosition;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(new RandomMovingStrategy());
            car.printPostion();
        }
    }
}
