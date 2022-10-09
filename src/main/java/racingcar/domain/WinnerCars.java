package racingcar.domain;

import racingcar.common.GameMessage;

import java.util.ArrayList;
import java.util.List;

public class WinnerCars {
    private final List<Car> winners;

    public WinnerCars(Ranking ranking) {
        this.winners = ranking.getWinnerCars();
    }
    public String getWinnerNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : this.winners) {
            carNames.add(car.getCarName());
        }
        return String.join(GameMessage.WINNER_DELIMITER, carNames);
    }
}
