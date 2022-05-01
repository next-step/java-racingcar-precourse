package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> winners;

    public Winner(Cars cars) {
        winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars.getCars());
        cars.getCars().forEach(car -> addWinner(car, maxPosition));
    }

    private int getMaxPosition(List<Car> carList) {
        carList.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
        return carList.get(0).getPosition();
    }

    private void addWinner(Car car, int position) {
        if (car.getPosition() == position) {
            winners.add(car);
        }
    }

    public List<Car> getWinners() {
        return winners;
    }
}
