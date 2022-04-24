package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Function;

public class RetryableInputReader {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    private RetryableInputReader() {
        throw new UnsupportedOperationException();
    }

    public static <T> T read(final InputType inputType, final Function<String, T> converter) {
        try {
            System.out.println(inputType.getGuideMessage());

            String input = Console.readLine().trim();
            return converter.apply(input);
        } catch (IllegalArgumentException e) {
            System.out.printf(ERROR_MESSAGE_FORMAT, e.getMessage());
            return read(inputType, converter);
        }
    }

}