package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String... carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void race() {
        for (Car car : cars) {
            car.tryRace();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car: cars) {
            addWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private int findMaxPosition() {
        int max = 0;
        for (Car car: cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    private void addWinner(List<Car> winners, Car car, int maxPosition) {
        if (car.isMaxPosition(maxPosition)) {
            winners.add(car);
        }
    }
}
