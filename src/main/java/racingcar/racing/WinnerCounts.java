package racingcar.racing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.car.Car;
import racingcar.car.Cars;

public class WinnerCounts {
    private Map<Car, Integer> winnerCountsMap;

    private WinnerCounts() {
        this.winnerCountsMap = new HashMap<>();
    }

    public static WinnerCounts init() {
        return new WinnerCounts();
    }

    public void countingCars(final Cars goCars) {
        goCars.each(car -> winnerCountsMap.put(car, getGoCarCountOrZero(car) + 1));
    }

    private int getGoCarCountOrZero(final Car car) {
        return winnerCountsMap.get(car) == null ? 0 : winnerCountsMap.get(car);
    }

    public Cars maxCountCars() {
        final Cars cars = Cars.init();

        for (Entry<Car, Integer> carIntegerEntry : winnerCountsMap.entrySet()) {
            findMaxCountCar(cars, carIntegerEntry);
        }

        return cars;
    }

    public boolean hasWinners() {
        return winnerCountsMap.size() > 0;
    }

    private void findMaxCountCar(final Cars cars, final Entry<Car, Integer> carIntegerEntry) {
        if (carIntegerEntry.getValue() == getMaxCount()) {
            cars.addCar(carIntegerEntry.getKey());
        }
    }

    private int getMaxCount() {
        int max = -1;
        for (Integer count : winnerCountsMap.values()) {
            max = checkMax(max, count);
        }
        return max;
    }

    private int checkMax(int max, final Integer count) {
        if (max <= count) {
           max = count;
        }
        return max;
    }
}
