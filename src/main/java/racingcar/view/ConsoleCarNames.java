package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import racingcar.model.cars.Cars;

public class ConsoleCarNames {
    public static final PrintMessage REQUEST_MESSAGE = PrintMessage.of("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    public static final PrintMessage EXCEPTION_MESSAGE_PREFIX = PrintMessage.of("[ERROR] ");
    public static final PrintMessage EXCEPTION_MESSAGE = PrintMessage.of("자동차 이름은 서로 중복 없이 1~5글자여야 한다.\n");

    public static Cars createCars() {
        try {
            ConsoleCarNames.printRequest();
            return Cars.of(ConsoleCarNames.read());
        } catch (IllegalArgumentException e) {
            return ConsoleCarNames.reCreateLapsByException();
        }
    }

    public static String read() throws NoSuchElementException {
        return Console.readLine();
    }

    public static void printRequest() {
        ConsoleCarNames.print(ConsoleCarNames.REQUEST_MESSAGE);
    }

    public static void printException() {
        ConsoleCarNames.print(PrintMessage.of(
                ConsoleCarNames.EXCEPTION_MESSAGE_PREFIX.toString() + ConsoleCarNames.EXCEPTION_MESSAGE.toString()));
    }

    private static Cars reCreateLapsByException() {
        ConsoleCarNames.printException();
        return ConsoleCarNames.createCars();
    }

    private static void print(PrintMessage printMessage) {
        System.out.print(printMessage.toString());
    }
}
