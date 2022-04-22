package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    public static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    public static final String WINNER_MESSAGE_DELIMITER = ", ";

    private final Cars cars;

    public RacingResult(Cars cars) {
        this.cars = cars;
    }

    public String createWinnerMessage() {
        List<Car> winners = cars.findWinnerCars();
        List<String> winnerNames = mappingToString(winners);
        return WINNER_MESSAGE_PREFIX + String.join(WINNER_MESSAGE_DELIMITER, winnerNames);
    }

    private List<String> mappingToString(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.toString());
        }
        return winnerNames;
    }
}
