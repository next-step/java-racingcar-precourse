package racingcar.domain;

import java.util.List;

public interface WinnerCondition {

    String getWinners(List<Car> cars, int maxForwardCount);
}
