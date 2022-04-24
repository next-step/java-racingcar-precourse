package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Sign;

public class Winners {

    private List<String> winner;
    private Headway maxHeadway;

    Winners(Headway maxHeadway) {
        this.maxHeadway = maxHeadway;
        this.winner = new ArrayList<>();
    }

    public void add(Car car) {
        if (car.isEqualHeaday(this.maxHeadway.getHeadway())) {
            this.winner.add(car.getCarName());
        }
    }

    public String toString() {
        return String.join(Sign.WINNER_JOIN_SIGN.getSign(), this.winner);
    }
}
