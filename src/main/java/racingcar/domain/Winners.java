package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static List<Car> getWinners(List<Car> carList) {
        List<Car> winnerList = new ArrayList<>();

        int maxPosition = findMaxPosition(carList);
        for (Car car : carList) {
            if (car.getPosition() >= maxPosition) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    private static int findMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }

}
