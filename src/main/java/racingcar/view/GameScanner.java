package racingcar.view;

import org.junit.platform.commons.util.StringUtils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameScanner {

    public static String[] scanCarNames() {
        GamePrinter.printCarNames();
        String read = readLine();
        return read.split(",");
    }

    public static int scanGameRounds() {
        GamePrinter.printGameRounds();
        String read = readLine();
        try {
            checkBlank(read);
            return getPositiveInteger(read);
        } catch (IllegalArgumentException e) {
            GamePrinter.printErrorValidNumber();
            return scanGameRounds();
        }
    }

    private static Integer getPositiveInteger(String read) {
        int rounds = Integer.parseInt(read);
        if (rounds < 0) {
            throw new IllegalArgumentException();
        }
        return rounds;
    }

    private static void checkBlank(String read) {
        if (StringUtils.isBlank(read)) {
            throw new IllegalArgumentException();
        }
    }
}
