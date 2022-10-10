package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private final CarList winnerLIst;

    public Referee(CarList carList) {
        int max = 0;
        for (Car car : carList.getCarList()) {
            max = Math.max(car.getLocation().getX(), max);
        }
        List<Car> winners = new ArrayList<>();
        for (Car car : carList.getCarList()) {
            confirmWinner(car, max, winners);
        }
        winnerLIst = new CarList(winners);
    }

    private void confirmWinner(Car car, int max, List<Car> winners) {
        if (car.getLocation().getX() == max) {
            winners.add(car);
        }
    }

    public CarList getWinnerList() {
        return this.winnerLIst;
    }
}
