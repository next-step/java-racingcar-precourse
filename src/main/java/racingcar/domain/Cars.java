package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String WINNER_SEPARATOR = ", ";

    private final List<Car> cars;
    private int maxMoveCount;

    private Cars(final List<Car> cars) {
        this.cars = cars;
        maxMoveCount = 0;
    }

    public static Cars of(final CarNames carNames) {
        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.getSize(); i++) {
            cars.add(Car.of(carNames.getCarName(i)));
        }
        return new Cars(cars);
    }

    public void moveCars(final TryCount tryCount) {
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            moveCarsOneTime();
            System.out.println();
        }
    }

    public String getWinners() {
        String winners = "";
        for (Car car : cars) {
            winners += verifyWinner(car);
        }
        return winners.substring(WINNER_SEPARATOR.length());
    }

    private void moveCarsOneTime() {
        for (Car car : cars) {
            car.move();
            car.printMoveResult();
            updateMaxMoveCount(car);
        }
    }

    private void updateMaxMoveCount(final Car car) {
        if (car.getMoveCount() > maxMoveCount) {
            maxMoveCount = car.getMoveCount();
        }
    }

    private String verifyWinner(final Car car) {
        if (car.getMoveCount() == maxMoveCount) {
            return WINNER_SEPARATOR + car.getCarName().getName();
        }
        return "";
    }

}
