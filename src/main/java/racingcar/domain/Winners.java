package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<CarName> winners = new ArrayList<>();

    public void add(CarName carName) {
        winners.add(carName);
    }

    public List<CarName> getWinners() {
        return winners;
    }
}
