package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;

public class RoundResults {
    private List<RoundResult> roundResults;

    private RoundResults(final List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public static RoundResults init() {
        return new RoundResults(new ArrayList<>());
    }

    public void result(final RoundResult report) {
        this.roundResults.add(report);
    }

    public Cars getGoCars() {
        final Cars cars = Cars.init();
        for (RoundResult roundResult : roundResults) {
            addGoCar(cars, roundResult);
        }
        return cars;
    }

    private void addGoCar(final Cars cars, final RoundResult roundResult) {
        if (roundResult.isGo()) {
            cars.addCar(roundResult.getCar());
        }
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public void addAll(final RoundResults roundResults) {
        this.roundResults.addAll(roundResults.getRoundResults());
    }

    public int summaryGoCount(final Car car) {
        int count = 0;
        for (RoundResult roundResult : roundResults) {
            count = getAndIncreaseCountByCar(car, count, roundResult);
        }

        return count;
    }

    private int getAndIncreaseCountByCar(final Car car, int count, final RoundResult roundResult) {
        if (roundResult.hasCar(car) && roundResult.isGo()) {
            count++;
        }
        return count;
    }
}
