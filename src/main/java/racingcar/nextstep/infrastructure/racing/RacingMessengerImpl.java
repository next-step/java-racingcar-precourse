package racingcar.nextstep.infrastructure.racing;

import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.racing.chart.RacingCharts;
import racingcar.nextstep.domain.racing.service.RacingMessenger;
import racingcar.nextstep.global.message.TextMessage;
import racingcar.nextstep.global.utils.Console;

public class RacingMessengerImpl implements RacingMessenger {

    @Override
    public String requestCarsName() {
        printMessage(TextMessage.REQUEST_CARS_NAME);
        return Console.readLine();
    }

    @Override
    public String requestAttemptsOfNumber() {
        printMessage(TextMessage.REQUEST_ATTEMPT_NUMBER);
        return Console.readLine();
    }

    @Override
    public void printResultMessage() {
        printMessage(TextMessage.RACING_RESULT);
    }

    @Override
    public void printRacingCharts(RacingCharts racingCharts) {
        racingCharts.getRacingResults().iterator().forEachRemaining(racingChart -> printMessage(racingChart.result()));
        printInLine();
    }

    @Override
    public void printWinners(Cars winnerCars) {
        final String winnersCarNameList = winnerCars.getCarNameList().toString();
        final String winners = winnersCarNameList.substring(1, winnersCarNameList.length() - 1);
        printMessage(TextMessage.RACING_WINNER_PREFIX + winners);
    }

    @Override
    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    private void printInLine() {
        System.out.println();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
