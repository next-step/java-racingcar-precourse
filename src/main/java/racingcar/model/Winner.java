package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private static final String WINNER_MESSAGE = "최종 우승자: ";
    private static final String DELIMITER = ", ";
    private final List<Car> winners;

    public Winner(List<Car> winners) {
        this.winners = winners;
    }

    public void printWinners() {
        System.out.println(WINNER_MESSAGE + generateWinnersNameMessage());
    }

    public String generateWinnersNameMessage() {
        return winners.stream().map(Car::getName).collect(Collectors.joining(DELIMITER));
    }
}
