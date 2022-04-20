package racingcar.controller;

import racingcar.error.Error;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingController {
    private final RacingService service = new RacingService();

    public void process() {
        final List<String> carNames = inputCarNameView();
        final int round = inputRoundView();
        final String winnerNames = service.play(carNames, round);
        OutputView.showResult(winnerNames);
    }

    private List<String> inputCarNameView() {
        final String[] carNames = InputView.inputCarName().split(",");
        try {
            validateIsMoreThan2(carNames);
            validateEachNameLengthLessThan5(carNames);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            inputCarNameView();
        }
        return Arrays.asList(carNames);
    }

    private static void validateIsMoreThan2(String[] inputNames) {
        if (inputNames.length < 2) {
            throw new IllegalArgumentException(Error.MUST_MORE_THAN_2.toString());
        }
    }

    private void validateEachNameLengthLessThan5(String[] carNames) {
        for (String carName : carNames) {
            isLengthLessThan5(carName);
        }
    }

    private void isLengthLessThan5(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(Error.MUST_LESS_THAN_5.toString());
        }
    }

    private int inputRoundView() {
        try {
            return parseToNumber(InputView.inputRound());
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return inputRoundView();
        }
    }

    private int parseToNumber(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Error.MUST_BE_NUMBER.toString());
        }
    }

    private static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
