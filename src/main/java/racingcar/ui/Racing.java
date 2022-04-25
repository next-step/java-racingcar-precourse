package racingcar.ui;

import racingcar.domain.AttemptCount;
import racingcar.domain.Cars;

public class Racing {
    private static final String SPACING_WARD = "\n";
    private static final int START_COUNT = 0;

    private Cars cars;
    private AttemptCount attemptCount;

    public Racing(Cars cars, AttemptCount attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public Cars start() {
        for (int startCount = START_COUNT; startCount < attemptCount.getAttemptCount(); startCount++) {
            System.out.print(cars.printCars());
            System.out.print(SPACING_WARD);
        }

        return cars;
    }


}
