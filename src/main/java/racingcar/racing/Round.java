package racingcar.racing;

import static racingcar.utils.ObjectUtils.isEmpty;

import racingcar.car.Cars;

public class Round {
    public enum Status {READY, FINISH}

    private Cars cars;
    private Status status;
    private RoundResults roundResults;

    private Round(final Cars cars) {
        this.cars = cars;
        this.status = Status.READY;
    }

    public static Round of(final Cars cars) {
        validateCars(cars);
        return new Round(cars);
    }

    public void start() {
        this.roundResults = cars.goOrStopAll();
        this.status = Status.FINISH;
    }

    public Cars getCars() {
        return cars;
    }

    public Cars getGoCars() {
        return roundResults.getGoCars();
    }

    public RoundResults getRoundResults() {
        return roundResults;
    }

    public boolean isFinish() {
        return this.status == Status.FINISH;
    }

    private static void validateCars(final Cars cars) {
        if (isEmpty(cars)) {
            throw new IllegalArgumentException("[ERROR] 실행을 하기위해서는 자동차들이 null 일 수 없습니다.");
        }
    }

}
