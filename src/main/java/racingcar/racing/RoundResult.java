package racingcar.racing;

import static racingcar.utils.ObjectUtils.isEmpty;

import racingcar.car.Car;

public class RoundResult {
    private Car car;
    private RacingCarResult racingCarResult;

    private RoundResult(final Car car, final RacingCarResult racingCarResult) {
        this.car = car;
        this.racingCarResult = racingCarResult;
    }

    public static RoundResult report(final Car car, final RacingCarResult race) {
        validateCar(car);
        validateRacingCarResult(race);
        return new RoundResult(car, race);
    }

    public boolean isGo() {
        return this.racingCarResult == RacingCarResult.GO;
    }

    public Car getCar() {
        return car;
    }

    public boolean hasCar(final Car car) {
        return this.car.equals(car);
    }

    private static void validateCar(final Car car) {
        if (isEmpty(car)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 null 일 수 없습니다.");
        }
    }

    private static void validateRacingCarResult(final RacingCarResult race) {
        if (isEmpty(race)) {
            throw new IllegalArgumentException("[ERROR] 전진 혹은 멈춤은 null 일 수 없습니다.");
        }
    }
}
