package racingcar.model;

import racingcar.model.Car;
import racingcar.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayResult {
    List<String> winners;

    public PlayResult() {
        winners = new ArrayList<>();
    }

    public String resultSetting() {
        return StringUtil.joinWithComma(winners);
    }

    public void report(Car car) {
        winners.add(car.getName());
    }
}
