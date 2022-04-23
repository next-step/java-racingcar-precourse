package racingcar.domain;

import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public boolean isSoleWinners() {
        return this.winners.size() == 1;
    }
}
