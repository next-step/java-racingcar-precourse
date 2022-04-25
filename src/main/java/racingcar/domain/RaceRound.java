package racingcar.domain;

import racingcar.util.RandomUtil;

public class RaceRound {

    private final Cars cars;
    private final RandomUtil randomUtil;

    private RaceRound(Cars cars, RandomUtil randomUtil) {
        this.cars = cars;
        this.randomUtil = randomUtil;
    }

    public static RaceRound of(Cars cars, RandomUtil randomUtil) {
        return new RaceRound(cars, randomUtil);
    }

    public RaceResult race() {
        moveCarWithRandomNumber();
        return RaceResult.of(cars);
    }

    private void moveCarWithRandomNumber() {
        for (Car car : cars.toList()) {
            int random = randomUtil.pickRaceNumber();
            car.moveByNumber(random);
        }
    }
}
