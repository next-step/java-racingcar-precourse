package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;

public class RacingWinnerMaxForwardStrategy implements WinnerCondition {

    @Override
    public String getWinners(List<Car> cars, int maxForwardCount) {
        StringJoiner result = new StringJoiner(", ");
        for (Car car : cars) {
            result.add(car.toStringIfWinner(maxForwardCount));
        }
        return result.toString();
    }
}
