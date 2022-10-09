package racingcar.context;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleScanner implements Scanner {

    private static final String EXCEPTION_MESSAGE = "[ERROR] 시도할 횟수가 잘못되었습니다.";

    @Override
    public String getNames() {
        return Console.readLine();
    }

    @Override
    public int getTry() {
        try {
            return Integer.parseInt(Console.readLine());
        }
        catch (Exception e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
