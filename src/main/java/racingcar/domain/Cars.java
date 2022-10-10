package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public Cars(CarNames carNames) {
        cars = new ArrayList<>();
        List<CarName> carNameList = carNames.getList();
        for (CarName carName : carNameList) {
            cars.add(new Car(carName));
        }
    }

    public void move(MoveCondition moveCondition) {
        for (Car car : cars) {
            car.move(moveCondition);
        }
    }

    public CarMovementsResults getCarsMovementResult() {
        List<CarMovementsResult> movementsResults = new ArrayList<>();

        for (Car car : cars) {
            movementsResults.add(
                    new CarMovementsResult(car.getName(), car.getMovements()));
        }

        return new CarMovementsResults(movementsResults);
    }

    public CarNames getWinners() {
        CarNames winners = CarNames.createEmpty();
        MoveCount mostForwardCount = getMostForwardCount();

        for (Car car : cars) {
            addIfEqualForwardCount(winners, mostForwardCount, car);
        }

        return winners;
    }

    private void addIfEqualForwardCount(CarNames winners, MoveCount mostForwardCount, Car car) {
        if (car.isEqualForwardCount(mostForwardCount)) {
            winners.add(car.getName());
        }
    }

    private MoveCount getMostForwardCount() {
        MoveCount mostForwardCount = new MoveCount(0);
        for (Car car : cars) {
            Movements movements = car.getMovements();
            MoveCount forwardCount = movements.getForwardCount();
            mostForwardCount =
                    forwardCount.isGreaterThanOrEqualTo(mostForwardCount) ? forwardCount : mostForwardCount;
        }

        return mostForwardCount;
    }
}
