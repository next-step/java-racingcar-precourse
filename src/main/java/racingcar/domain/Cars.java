package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> getWinners() {
        return getWinners(getMaxPosition());
    }

    private List<Car> getWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxPosition.equals(car.getPosition())) {
                winners.add(car);
            }
        }
        return winners;
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

}
