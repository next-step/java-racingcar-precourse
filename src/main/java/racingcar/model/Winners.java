package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static final String DELIMITER = ", ";

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        this.winners = cars;
    }

    public String getWinners() {
        return winners.stream()
                .map(Car::name)
                .collect(Collectors.joining(DELIMITER));
    }
}
