package racingcar.view;

import racingcar.constants.ProcessIndicator;
import racingcar.constants.SystemMessage;
import racingcar.controller.RacingGameController;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingTryCount;
import racingcar.utils.MessagePrinter;

public class RacingGame {

    private final RacingGameController racingGameController;
    private final MessagePrinter messagePrinter;
    private ProcessIndicator processIndicator;
    private RacingCars racingCars;
    private RacingTryCount racingTryCount;

    public RacingGame(final RacingGameController racingGameController, final MessagePrinter messagePrinter) {
        this.racingGameController = racingGameController;
        this.messagePrinter = messagePrinter;
        this.processIndicator = ProcessIndicator.INIT;
    }

    public void start() {
        receivePlayerInput();
        if (processIndicator == ProcessIndicator.COUNT_SET) {
            racingStart();
            showGameResult();
        }
    }

    private void receivePlayerInput() {
        if (processIndicator == ProcessIndicator.INIT) {
            makingCarProcess();
        }
        if (processIndicator == ProcessIndicator.CAR_SET) {
            settingTryCountProcess();
        }
    }

    private void makingCarProcess() {
        messagePrinter.printMessage(SystemMessage.INPUT_CAR_NAMES);
        final String carNames = racingGameController.getInput();
        try {
            racingCars = racingGameController.makeCars(carNames);
            processIndicator = ProcessIndicator.CAR_SET;
        } catch (IllegalArgumentException e) {
            messagePrinter.printMessage(e.getMessage());
            receivePlayerInput();
        }
    }


    private void settingTryCountProcess() {
        messagePrinter.printMessage(SystemMessage.INPUT_TRY_COUNT);
        final String tryCount = racingGameController.getInput();
        try {
            racingTryCount = racingGameController.validateTryCount(tryCount);
            processIndicator = ProcessIndicator.COUNT_SET;
        } catch (IllegalArgumentException e) {
            messagePrinter.printMessage(e.getMessage());
            receivePlayerInput();
        }
    }

    private void racingStart() {
        messagePrinter.printMessage(SystemMessage.RACING_RESULT);
        for (int i = 0; i < racingTryCount.getCount(); i++) {
            racingCars.raceAll();
            racingCars.printRacingCarsState();
        }
    }

    private void showGameResult() {
        final RacingCars winners = racingCars.getWinners();
        final StringBuilder builder = new StringBuilder();
        for(int i = 0; i < winners.size(); i++){
            final RacingCar racingCar = winners.get(i);
            builder.append(racingCar.getName()).append(", ");
        }
        System.out.printf("최종 우승자: %s", builder.substring(0, builder.length() - 2));
    }

}
