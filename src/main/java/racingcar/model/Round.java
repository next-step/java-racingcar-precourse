package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Round {
    public void play(Cars cars, MaxForwardCount maxForwardCount) {
        for (Car car : cars.getCars()) {
            car.setForwardResultByRandomNum(new RandomNum());
            maxForwardCount.setMaxCount(car.getForwardCount().getCount());
        }
    }

    public List<String> getWinnerNames(Cars cars, MaxForwardCount maxForwardCount) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (maxForwardCount.getMaxCount() == car.getForwardCount().getCount()) {
                winnerNames.add(car.getName().getCarName());
            }
        }
        return winnerNames;
    }
}