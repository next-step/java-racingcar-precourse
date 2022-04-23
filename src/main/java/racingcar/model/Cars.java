package racingcar.model;


import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race() {
        getCars().forEach(car -> {
            car.move(CarEngine.charge(RandomUtil.create()));
        });
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName: carNames) {
            cars.add(Car.create(carName));
        }
        return new Cars(cars);
    }

    public List<String> getWinnerCarNames() {
        int winnerCarPosition = Collections.max(cars).getPosition();
        List<String> winnerCarNames = new ArrayList<>();
        cars.forEach(car -> findAllWinners(car, winnerCarPosition, winnerCarNames));
        return Collections.unmodifiableList(winnerCarNames);
    }

    private void findAllWinners(Car car, int winnerCarPosition, List<String> winnerCarNames) {
        if (winnerCarPosition == car.getPosition()) {
            winnerCarNames.add(car.getName());
        }
    }
}
