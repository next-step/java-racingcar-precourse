package racingcar.service;

import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;

public class RacingGameOrganizer {

    private Cars cars;
    private TryCount tryCount;

    public Cars getCars() {
        return cars;
    }

    public void setCars(final String carNamesInput) {
        cars = Cars.of(CarNames.of(carNamesInput));
    }

    public TryCount getTryCount() {
        return tryCount;
    }

    public void setTryCount(final String tryCountInput) {
        tryCount = TryCount.of(tryCountInput);
    }

}
