package racingcar.domain.racing.result;

import java.util.List;
import racingcar.domain.car.Car;

public interface Result {

    String LINE_BREAK = "\n";
    String SEPARATOR = ", ";

    String moveResult(List<Car> cars, List<Integer> randoms);
}
