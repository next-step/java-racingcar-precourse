package racingcar.domain;

import racingcar.common.GameMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 최종 우승자 목록
 *
 * @author suji
 * @date 2022-04-24
 **/
public class FinalWinners {

    private final List<Car> winners;

    public FinalWinners(Ranking ranking) {
        this.winners = ranking.getWinnerCars();
    }

    public String getWinnerNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : this.winners) {
            carNames.add(car.getCarName());
        }
        return String.join(GameMessage.WINNER_DELIMITER, carNames);
    }

    public List<Car> getWinners() {
        return winners;
    }
}
