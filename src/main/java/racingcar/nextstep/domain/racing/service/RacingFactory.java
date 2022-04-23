package racingcar.nextstep.domain.racing.service;

import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;
import racingcar.nextstep.domain.racing.chart.RacingCharts;

public interface RacingFactory {
    String[] splitCarsNameWithComma(String carsName);

    CarsName createCarsName(String[] carNameList);

    int convertStringNumberToInteger(String attemptsOfNumber);

    RacingCharts createRacingCharts(Cars cars);
}
