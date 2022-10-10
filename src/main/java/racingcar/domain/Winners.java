package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(Ranking ranking) {
        this.winners = ranking.getFirstRankers();
    }

    public String getWinRacers() {
        List<String> carNames = new ArrayList<>();
        for (Car car: this.winners) {
            carNames.add(car.getCarName());
        }

        return String.join(",", carNames);
    }
}
