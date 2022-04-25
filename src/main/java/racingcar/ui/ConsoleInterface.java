package racingcar.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInterface implements UserInterface {

    private static final ConsoleInterface consoleInterface
            = new ConsoleInterface();

    private ConsoleInterface() {
    }

    public static ConsoleInterface getInstance() {
        return consoleInterface;
    }

    @Override
    public String input() {
        return readLine();
    }

    @Override
    public void output(String str) {
        System.out.print(str);
    }
}
