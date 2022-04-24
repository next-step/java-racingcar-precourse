package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String REQUEST_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_COUNT = "시도할 횟수는 몇 회인가요?";

    public static String readUserInput(String question) {
        System.out.println(question);
        return Console.readLine();
    }
}
