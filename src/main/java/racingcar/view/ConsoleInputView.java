package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {
    private ConsoleInputView() {

    }

    public static String readCarNames() {
        ConsoleOutputView.println("경주할 자동차 이름을 입력하세요.(이름 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String readMoveCount() {
        ConsoleOutputView.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
