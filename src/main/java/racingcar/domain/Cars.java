package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        return getWinnersBy(getMaxPosition());
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = maxPosition.max(maxPosition, car.getCurrentPositon());
        }
        return maxPosition;
    }

    private List<Car> getWinnersBy(Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.add(car.isWinner(maxPosition));
        }
        winners.removeAll(Collections.singletonList(null));
        return winners;
    }


    public void moveCars(MovingStrategy movingStrategy) {
        for(Car car: cars) {
            car.move(movingStrategy);
        }
    }

    public String getMoveResult() {
        StringBuilder moveResult = new StringBuilder();
        for(Car car: cars) {
            moveResult.append(car.getMoveResult()).append("\n");
        }
        return moveResult.toString();
    }
}
