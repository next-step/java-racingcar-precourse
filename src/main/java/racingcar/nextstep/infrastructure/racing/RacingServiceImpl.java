package racingcar.nextstep.infrastructure.racing;

import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;
import racingcar.nextstep.domain.racing.chart.RacingCharts;
import racingcar.nextstep.domain.racing.service.*;
import racingcar.nextstep.global.message.Number;

public class RacingServiceImpl implements RacingService {

    private final RacingMessenger racingMessenger;
    private final RacingValidator racingValidator;
    private final RacingFactory racingFactory;
    private final RacingReferee racingReferee;

    public RacingServiceImpl(RacingMessenger racingMessenger, RacingValidator racingValidator, RacingFactory racingFactory, RacingReferee racingReferee) {
        this.racingMessenger = racingMessenger;
        this.racingValidator = racingValidator;
        this.racingFactory = racingFactory;
        this.racingReferee = racingReferee;
    }

    @Override
    public CarsName requestCarsName() {
        final String carsName = racingMessenger.requestCarsName();
        final String[] splitCarNames = racingFactory.splitCarsNameWithComma(carsName);

        try{
            racingValidator.isCarNameNotExceedingFive(splitCarNames);
            racingValidator.isCarNameNotBlank(splitCarNames);
        } catch (IllegalArgumentException e) {
            racingMessenger.printErrorMessage(e);
            return requestCarsName();
        }

        return racingFactory.createCarsName(splitCarNames);
    }

    @Override
    public int requestAttemptsOfNumber() {
        final String stringNumber = racingMessenger.requestAttemptsOfNumber();

        try {
            racingValidator.isNumber(stringNumber);
        } catch (IllegalArgumentException e) {
            racingMessenger.printErrorMessage(e);
            return requestAttemptsOfNumber();
        }

        return racingFactory.convertStringNumberToInteger(stringNumber);
    }

    @Override
    public void startRacing(Cars cars, int attemptsOfNumber) {
        racingMessenger.printResultMessage();
        for (int i = Number.MIN_VALUE; i < attemptsOfNumber; i++) {
            cars.racing();
        }
    }

    @Override
    public void printRacingResult(Cars cars, int attemptsOfNumber) {
        for (int i = Number.MIN_VALUE; i < attemptsOfNumber; i++) {
            final RacingCharts racingCharts = racingFactory.createRacingCharts(cars);
            racingMessenger.printRacingCharts(racingCharts);
        }
    }

    @Override
    public Cars findWinners(Cars cars) {
        return racingReferee.findWinners(cars);
    }

    @Override
    public void printWinners(Cars winnerCars) {
        racingMessenger.printWinners(winnerCars);
    }

}
