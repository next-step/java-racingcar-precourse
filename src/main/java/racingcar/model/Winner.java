package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winners = new ArrayList<>();

    public Winner(Cars cars) {
        int maxPosition = cars.getMaxPosition();
        for (Car car : cars.getCars()) {
            findWinner(maxPosition, car);
        }
    }

    private void findWinner(int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    public int getSize() {
        return winners.size();
    }

    @Override
    public String toString() {
        return "최종 우승자: " + String.join(",", winners);
    }
}
