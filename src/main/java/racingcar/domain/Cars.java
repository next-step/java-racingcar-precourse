package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.core.Constant.NAME_SEPARATOR;
import static racingcar.core.Constant.SEPARATOR;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> racingCars) {
        this.cars = racingCars;
    }

    public String playRound() {
        StringBuffer sb = new StringBuffer();
        for (Car car : this.cars) {
            sb.append(car.getName() + NAME_SEPARATOR)
                    .append(car.moveOrStop())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getWinner() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            compareDistance(Collections.max(cars).getDistance().getDistance(), car, winnerList);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(String.join(SEPARATOR, winnerList));
        return sb.toString();
    }

    private void compareDistance(int distance, Car car, List<String> winnerList) {
        if (distance == car.getDistance().getDistance()) {
            winnerList.add(car.getName());
        }
    }
}
