package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.vo.Car;
import racingcar.model.vo.CarState;
import racingcar.model.vo.Entry;

public class RoundResult {

    private List<CarState> roundResult;

    public RoundResult(Entry entry) {
        roundResult = new ArrayList<>();
        for (Car car : entry.getEntry()) {
            this.roundResult.add(new CarState(car));
        }
    }

    public List<CarState> getRoundResult() {
        return roundResult;
    }
}
