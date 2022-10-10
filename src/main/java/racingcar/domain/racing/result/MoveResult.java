package racingcar.domain.racing.result;

import java.util.List;
import racingcar.domain.car.Car;

public class MoveResult implements Result {

    private StringBuilder result;

    public MoveResult() {
        this.result = new StringBuilder();
    }

    @Override
    public String moveResult(List<Car> cars, List<Integer> randoms) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            Integer random = randoms.get(i);
            result.append(car.move(random)).append(LINE_BREAK);
        }
        result.append(LINE_BREAK);
        return result.toString();
    }
}
