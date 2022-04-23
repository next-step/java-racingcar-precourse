package racingcar.nextstep.domain.racing.service;

import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.racing.chart.RacingCharts;

public interface RacingMessenger {
    String requestCarsName();

    String requestAttemptsOfNumber();

    void printResultMessage();

    void printRacingCharts(RacingCharts racingCharts);

    void printWinners(Cars winnerCars);

    void printErrorMessage(Exception e);
}
