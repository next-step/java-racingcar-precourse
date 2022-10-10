package racingcar;

import racingcar.domain.car.CarMovingStrategy;
import racingcar.domain.car.DefaultRandomIntGenerator;
import racingcar.domain.car.RandomMovingStrategy;
import racingcar.domain.racing.CarStatuses;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.RacingCars;
import racingcar.ui.CarNamesInput;
import racingcar.ui.CarNamesInputView;
import racingcar.ui.ExceptionOutputView;
import racingcar.ui.RacingOutputView;
import racingcar.ui.RacingTrialsInput;
import racingcar.ui.RacingTrialsInputView;

public class Application {
    private static final DefaultRandomIntGenerator RANDOM_INT_GENERATOR = new DefaultRandomIntGenerator();
    private static final CarMovingStrategy MOVING_STRATEGY = new RandomMovingStrategy(RANDOM_INT_GENERATOR);

    public static void main(String[] args) {
        final RacingCars cars = createRacingCars();
        final Racing racing = createRacing(cars);
        race(racing);
    }

    private static RacingCars createRacingCars() {
        try {
            final CarNamesInput carNamesInput = CarNamesInputView.inputCarNames();
            return RacingCars.createdBy(carNamesInput.getCarNames(), MOVING_STRATEGY);
        } catch (IllegalArgumentException e) {
            ExceptionOutputView.printMessage(e);
            return createRacingCars();
        }
    }

    private static Racing createRacing(RacingCars cars) {
        try {
            final RacingTrialsInput racingTrialsInput = RacingTrialsInputView.inputRacingTrials();
            final int racingTrials = racingTrialsInput.getRacingTrials();
            return new Racing(cars, racingTrials);
        } catch (IllegalArgumentException e) {
            ExceptionOutputView.printMessage(e);
            return createRacing(cars);
        }
    }

    private static void race(Racing racing) {
        RacingOutputView.printRacingStart();
        while (!racing.isFinished()) {
            final CarStatuses carStatuses = racing.raceOnce();
            RacingOutputView.printCarStatuses(carStatuses);
        }

        final CarStatuses winners = racing.getWinners();
        RacingOutputView.printWinners(winners);
    }
}
