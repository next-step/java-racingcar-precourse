package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import racingcar.model.laps.Laps;

public class ConsoleLaps {
    public static final PrintMessage REQUEST_MESSAGE = PrintMessage.of("시도할 회수는 몇회인가요?\n");
    public static final PrintMessage EXCEPTION_MESSAGE_PREFIX = PrintMessage.of("[ERROR] ");
    public static final PrintMessage EXCEPTION_MESSAGE = PrintMessage.of("시도 횟수는 숫자여야 한다.\n");

    public static Laps createLaps() {
        try {
            ConsoleLaps.printRequest();
            return Laps.of(ConsoleLaps.read());
        } catch (IllegalArgumentException e) {
            return ConsoleLaps.reCreateLapsByException();
        }
    }

    public static String read() throws NoSuchElementException {
        return Console.readLine();
    }

    public static void printRequest() {
        ConsoleLaps.print(ConsoleLaps.REQUEST_MESSAGE);
    }

    public static void printException() {
        ConsoleLaps.print(PrintMessage.of(
                ConsoleLaps.EXCEPTION_MESSAGE_PREFIX.toString() + ConsoleLaps.EXCEPTION_MESSAGE.toString()));
    }

    private static Laps reCreateLapsByException() {
        ConsoleLaps.printException();
        return ConsoleLaps.createLaps();
    }

    private static void print(PrintMessage printMessage) {
        System.out.print(printMessage.toString());
    }
}
