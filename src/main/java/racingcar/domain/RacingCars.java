package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public RacingCars(List<Car> cars) {
        this(cars, new RandomMovingStrategy());
    }

    public RacingCars(List<Car> cars, MovingStrategy movingStrategy) {
        if (movingStrategy == null) {
            throw new IllegalArgumentException("이동 전략으로 Null을 사용할 수 없습니다");
        }
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public void playRound() {
        for (Car car: cars) {
            car.move(movingStrategy);
        }
    }

    public Winners getWinners() {
        return new Winners(findWinnerCars(findMaxPosition()));
    }

    private int findMaxPosition() {
        int position = Car.DEFAULT_POSITION;
        for (Car car: cars) {
            position = Math.max(car.getPosition(), position);
        }
        return position;
    }

    private List<Car> findWinnerCars(int maxPosition) {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car: cars) {
            containWinner(winnerCars, car, maxPosition);
        }
        return winnerCars;
    }

    private void containWinner(List<Car> winnerNames, Car car, int winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            winnerNames.add(car);
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
