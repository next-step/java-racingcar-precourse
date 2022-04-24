package racingcar.ui;

import static racingcar.constant.ErrorStatus.NUMBER_OF_ATTEMPTS_PATTERN_NOT_MATCHED;

import java.util.regex.Pattern;
import racingcar.constant.InputStatus;
import racingcar.domain.NumberOfAttempts;

public class NumberOfAttemptsInputView {

    private static final Pattern pattern = Pattern.compile("^[0-9]*$");
    private static InputStatus status = InputStatus.INPUT_IN_PROGRESS;

    public static NumberOfAttempts get() {
        NumberOfAttempts attempts = null;
        while (status.isContinue()) {
            attempts = getNumberOfAttemptsFromInput();
        }
        return attempts;
    }

    private static NumberOfAttempts getNumberOfAttemptsFromInput() {
        try {
            String input = InputView.getConsoleInputWithMessage("시도 횟수: ");
            validateConsoleInput(input);
            status = InputStatus.INPUT_END;
            return new NumberOfAttempts(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            status = InputStatus.INPUT_IN_PROGRESS;
        }
        return null;
    }

    private static void validateConsoleInput(String input) {
        if (!pattern.matcher(input).find()) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_PATTERN_NOT_MATCHED.getMessage());
        }
    }

}
