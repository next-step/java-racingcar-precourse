package racingcar.view.userinferface.scanner;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleScanner implements Scanner {
    @Override
    public String read() {
        return Console.readLine();
    }
}
