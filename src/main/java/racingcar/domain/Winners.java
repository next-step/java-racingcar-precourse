package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> values;

    public Winners(Cars cars) {
        this.values = getWinners(cars);
    }

    public List<Car> getWinners(Cars cars) {
        List<Car> winnerList = new ArrayList<>();

        for (Car car : cars.getValues()) {
            addWinner(cars, winnerList, car);
        }
        return winnerList;
    }

    private void addWinner(Cars cars, List<Car> winnerList, Car car) {
        if (car.getPosition().getValue() == cars.getLargestPositionAmongCars()) {
            winnerList.add(car);
        }
    }

    public String getWinnersMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자: ");
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i).getName().getValue());
            if (i != values.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
