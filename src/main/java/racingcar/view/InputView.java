package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class InputView {

    private static final String RACING_CAR_NAME_INPUT_DELIMITER = ",";

    private final Supplier<String> inputSupplier;

    public InputView(final Supplier<String> inputSupplier) {
        this.inputSupplier = inputSupplier;
    }

    public List<String> readRacingCarNames() {
        final String input = inputSupplier.get();
        return Arrays.asList(input.split(RACING_CAR_NAME_INPUT_DELIMITER));
    }

    public int readMoveCount() {
        try {
            final String input = inputSupplier.get();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
