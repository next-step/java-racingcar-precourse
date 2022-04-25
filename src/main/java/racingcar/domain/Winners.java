package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 12:26
 */
public class Winners {
    private List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public String getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            winnerNames.add(car.getCarName());
        }
        return String.join(", ", winnerNames);
    }
}
