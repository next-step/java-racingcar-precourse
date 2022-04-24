package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.util.Constants;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void moveCars() {
        for (Car car : carList) {
            car.move(Randoms.pickNumberInRange(Constants.RANDOM_MIN_NUMBER,
                Constants.RANDOM_MAX_NUMBER));
        }
    }

    public List<Car> getWinner() {
        Position maxPosition = findMaxPosition();
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : carList) {
            addWinner(car, maxPosition, winnerCars);
        }
        return winnerCars;
    }

    public void addWinner(Car car, Position position, List<Car> winnerCars) {
        if (car.isWinnerCar(position)) {
            winnerCars.add(car);
        }
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getValue() {
        return carList;
    }

}
